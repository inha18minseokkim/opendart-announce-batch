package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.Business.ApiReceive;
import com.example.opendartannouncereceivebatch.Mapper.AnnounceDefaultMapper;
import com.example.opendartannouncereceivebatch.Repository.AnnounceDefaultRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DailyAnnounceApiReceiveTasklet implements Tasklet {
    private ApiReceive apiReceive;
    private AnnounceDefaultMapper announceDefaultMapper;
    private AnnounceDefaultRepository announceDefaultRepository;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        //beginDate, endDate 명세 받아오
        String beginDate = chunkContext.getStepContext().getStepExecution().getJobParameters().getString("beginDate");
        String endDate = chunkContext.getStepContext().getStepExecution().getJobParameters().getString("endDate");
        log.info(String.format("%s ~ %s 모든 기업 공시정보 가져오기",beginDate,endDate));
        apiReceive.getAnnouncementList(beginDate, endDate).map(announceDefaultMapper::from).forEach((announceDefault -> {
            log.info(announceDefault.toString());
            announceDefaultRepository.save(announceDefault);
        }));

        return RepeatStatus.FINISHED;
    }
}
