package com.example.opendartannouncereceivebatch.Step;

import com.example.opendartannouncereceivebatch.Tasklet.DailyAnnounceApiReceiveTasklet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.LocalDateTime;
import java.util.Set;

@Configuration
@AllArgsConstructor
@Slf4j
public class DefaultAnnouncementApiReceiveStepConfig {
    private DailyAnnounceApiReceiveTasklet dailyAnnounceApiReceiveTasklet;
    private PlatformTransactionManager platformTransactionManager;
    private ApplicationArguments applicationArguments;
    @Bean
    public Job ExampleJob(JobRepository jobRepository){
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);
        log.info(String.format("환경변수 설정 완료 beginDate : %s / endDate : %s ",beginDate,endDate));
        Job exampleJob = new JobBuilder(String.format("dailyReceiveJob:%s", LocalDateTime.now()),jobRepository)
                .start(dailyReceiveStep(beginDate,endDate,jobRepository,dailyAnnounceApiReceiveTasklet,platformTransactionManager)).build();
        return exampleJob;
    }

    @Bean
    @JobScope
    public Step dailyReceiveStep( @Value("#{jobParameters[beginDate]}")String beginDate
                                , @Value("#{jobParameters[endDate]}")String endDate
                                , JobRepository jobRepository
                                , DailyAnnounceApiReceiveTasklet defaultTasklet
                                , PlatformTransactionManager transactionManager) {
        return new StepBuilder("dailyReceiveStep",jobRepository)
                .tasklet(defaultTasklet,transactionManager).build();
    }

}
