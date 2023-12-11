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
@Slf4j
public class PaidIncreaseReceiveTasklet implements Tasklet {
    private final ApplicationArguments applicationArguments;
    private final AnnounceDefaultReader announceDefaultReader;
    private final EssentialApiReceive essentialApiReceive;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);
        //그냥 공시에서 주요사항,증자,유상 이라는 제목을 가지고 있는 공시정보들을 가져옴
        Stream<AnnounceDefault> announceStream = announceDefaultReader.getAnnounceList(beginDate, endDate)
                .filter((AnnounceDefault element) -> element.getReportNm().contains("주요사항"))
                .filter((AnnounceDefault element) -> element.getReportNm().contains("증자"))
                .filter((AnnounceDefault element) -> element.getReportNm().contains("유상"));
        //회사코드를 추출해서 그걸로 유상증자 enum 멤버의 uri로 찌름
        Stream<? extends EssentialResponseElement> elementStream = announceStream.flatMap((AnnounceDefault element) -> {
                log.info(element.getCorpCode() + " : " + element.getReportNm() + " 에 대한 호출 진행");
                return essentialApiReceive.getEssentialAnnouncement(beginDate, endDate, element.getCorpCode(), AnnounceKindCode.PAID_INCREASE);
                }
        ).map(EssentialResponseElement::getRefinedElement);
        //그걸 EssentialResponseElement 리스트를 반환하는 ApiReceive 인터페이스 로직을 호출해서 구체 클래스로 반환
        Stream<? extends EssentialReport> entityStream = essentialApiReceive.convertToEntity(elementStream, AnnounceKindCode.PAID_INCREASE);
        //Mapper 인터페이스를 호출해서 가져옴
        Integer integer = essentialApiReceive.saveRepository(entityStream, AnnounceKindCode.PAID_INCREASE);
        //writer 인터페이스를 호출해서 적재
        return RepeatStatus.FINISHED;
    }
}
