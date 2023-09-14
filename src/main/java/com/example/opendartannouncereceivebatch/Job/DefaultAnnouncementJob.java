package com.example.opendartannouncereceivebatch.Job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DefaultAnnouncementJob {

    @Bean
    public Job dataReceiveJob(JobRepository jobRepository, Step step){
            return new JobBuilder("dataReceiveJob", jobRepository).start(step).build();
    }

}