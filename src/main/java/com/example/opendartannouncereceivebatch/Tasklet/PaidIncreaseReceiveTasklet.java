package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.Business.EssentialApiReceive;
import com.example.opendartannouncereceivebatch.Code.AnnounceKindCode;
import com.example.opendartannouncereceivebatch.DTO.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Reader.AnnounceDefaultReader;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class PaidIncreaseReceiveTasklet implements Tasklet {
    private final ApplicationArguments applicationArguments;
    private final AnnounceDefaultReader announceDefaultReader;
    private final EssentialApiReceive essentialApiReceive;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);

        Stream<AnnounceDefault> announceStream = announceDefaultReader.getAnnounceList(beginDate, endDate)
                .filter((AnnounceDefault element) -> element.getReportName().contains("증자"))
                .filter((AnnounceDefault element) -> element.getReportName().contains("유상"));

        Stream<? extends EssentialResponseElement> elementStream = announceStream.map((AnnounceDefault element) ->
                essentialApiReceive.getEssentialAnnouncement(beginDate, endDate, element.getCorpCode(), AnnounceKindCode.PAIDINCREASE)
        ).flatMap(Function.identity());

        Stream<? extends EssentialReport> entityStream = essentialApiReceive.convertToEntity(elementStream, AnnounceKindCode.PAIDINCREASE);

        Integer integer = essentialApiReceive.saveRepository(entityStream, AnnounceKindCode.PAIDINCREASE);

        return RepeatStatus.FINISHED;
    }
}
