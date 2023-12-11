package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.Business.EssentialApiReceive;
import com.example.opendartannouncereceivebatch.Code.AnnounceKindCode;
import com.example.opendartannouncereceivebatch.DTO.ListElement.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Reader.AnnounceDefaultReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
@Slf4j
public class EssentialCommonTasklet implements Tasklet {
    private final ApplicationArguments applicationArguments;
    private final EssentialApiReceive essentialApiReceive;
    private final AnnounceDefaultReader announceDefaultReader;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);

        for(AnnounceKindCode value : AnnounceKindCode.values()){
            log.info("{} 작업 진행",value.getClass());
            Stream<AnnounceDefault> announceStream = announceDefaultReader.getAnnounceList(beginDate, endDate)
                    .filter(value.getFilter());

            Stream<? extends EssentialResponseElement> elementStream = announceStream.flatMap((AnnounceDefault element) -> {
                        log.info(element.getCorpCode() + " : " + element.getReportNm() + " 에 대한 호출 진행");
                        return essentialApiReceive.getEssentialAnnouncement(beginDate, endDate, element.getCorpCode(), value);
                    }
            ).map(EssentialResponseElement::getRefinedElement);

            Stream<? extends EssentialReport> entityStream = essentialApiReceive.convertToEntity(elementStream, value);

            Integer integer = essentialApiReceive.saveRepository(entityStream, value);
        }

        return RepeatStatus.FINISHED;

    }
}
