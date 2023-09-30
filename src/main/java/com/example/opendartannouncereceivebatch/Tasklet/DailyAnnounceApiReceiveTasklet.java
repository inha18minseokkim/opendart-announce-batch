package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.Business.DefaultApiReceive;
import com.example.opendartannouncereceivebatch.Mapper.AnnounceDefaultMapper;
import com.example.opendartannouncereceivebatch.Repository.AnnounceDefaultRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;


@Slf4j
@AllArgsConstructor
@StepScope
@Component
public class DailyAnnounceApiReceiveTasklet implements Tasklet {

    private final DefaultApiReceive defaultApiReceive;
    private final AnnounceDefaultMapper announceDefaultMapper;
    private final AnnounceDefaultRepository announceDefaultRepository;
    private final ApplicationArguments applicationArguments;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);

        log.info(String.format("%s ~ %s 모든 기업 공시정보 가져오기",beginDate,endDate));
        defaultApiReceive.getAnnouncementList(beginDate, endDate).filter((ele) -> ele!=null)
                .map(announceDefaultMapper::from).forEach((announceDefault -> {
            //log.info(announceDefault.toString());
            announceDefaultRepository.save(announceDefault);
        }));

        return RepeatStatus.FINISHED;
    }
}
