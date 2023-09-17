package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.Business.ApiReceive;
import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.Mapper.AnnounceDefaultMapper;
import com.example.opendartannouncereceivebatch.Repository.AnnounceDefaultRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
@AllArgsConstructor
public class DailyAnnounceApiReceive implements Tasklet {
    private ApiReceive apiReceive;
    private AnnounceDefaultMapper announceDefaultMapper;
    private AnnounceDefaultRepository announceDefaultRepository;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        //beginDate, endDate 명세 받아오기
        apiReceive.getAnnouncementList("", "").map(announceDefaultMapper::from).forEach((announceDefault -> {
            announceDefaultRepository.save(announceDefault);
        }));

        return RepeatStatus.FINISHED;
    }
}
