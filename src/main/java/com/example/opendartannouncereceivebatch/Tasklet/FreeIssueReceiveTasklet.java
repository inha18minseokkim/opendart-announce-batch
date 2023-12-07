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
public class FreeIssueReceiveTasklet implements Tasklet {
    private final ApplicationArguments applicationArguments;
    private final EssentialApiReceive essentialApiReceive;
    private final AnnounceDefaultReader announceDefaultReader;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);

        Stream<AnnounceDefault> announceStream = announceDefaultReader.getAnnounceList(beginDate, endDate)
                .filter((AnnounceDefault element) -> element.getReportNm().contains("주요사항"))
                .filter((AnnounceDefault element) -> element.getReportNm().contains("증자"))
                .filter((AnnounceDefault element) -> element.getReportNm().contains("무상"));

        Stream<? extends EssentialResponseElement> elementStream = announceStream.flatMap((AnnounceDefault element) -> {
                    log.info(element.getCorpCode() + " : " + element.getReportNm() + " 에 대한 호출 진행");
                    return essentialApiReceive.getEssentialAnnouncement(beginDate, endDate, element.getCorpCode(), AnnounceKindCode.FREE_ISSUE);
                }
        ).map(EssentialResponseElement::getRefinedElement);

        Stream<? extends EssentialReport> entityStream = essentialApiReceive.convertToEntity(elementStream, AnnounceKindCode.FREE_ISSUE);

        Integer integer = essentialApiReceive.saveRepository(entityStream, AnnounceKindCode.FREE_ISSUE);

        return RepeatStatus.FINISHED;

    }
}
