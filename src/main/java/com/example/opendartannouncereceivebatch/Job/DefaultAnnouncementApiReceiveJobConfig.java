package com.example.opendartannouncereceivebatch.Job;

import com.example.opendartannouncereceivebatch.Tasklet.DailyAnnounceApiReceiveTasklet;
import com.example.opendartannouncereceivebatch.Tasklet.PaidIncreaseReceiveTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class DefaultAnnouncementApiReceiveJobConfig {
    private final DailyAnnounceApiReceiveTasklet dailyAnnounceApiReceiveTasklet;
    private final PaidIncreaseReceiveTasklet paidIncreaseReceiveTasklet;
    private final ApplicationArguments applicationArguments;

    @Bean
    public Job dailyReceiveJob(JobRepository jobRepository,
                               PlatformTransactionManager transactionManager){
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);
        log.info(String.format("dailyReceiveJob 실행 시작 %s ~ %s",beginDate,endDate));

        Job exampleJob = new JobBuilder(String.format("dailyReceiveJob%s%s",beginDate,endDate),jobRepository)
                .start(dailyReceiveStep(jobRepository,dailyAnnounceApiReceiveTasklet,transactionManager))
                .next(dailyPaidIncreaseReceiveStep(jobRepository, paidIncreaseReceiveTasklet, transactionManager))
                .build();
        return exampleJob;
    }

    @Bean
    @JobScope
    public Step dailyReceiveStep(JobRepository jobRepository
                                , DailyAnnounceApiReceiveTasklet defaultTasklet
                                , PlatformTransactionManager transactionManager) {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);
        log.info(String.format("%s ~ %s dailyReceiveStep 실행",beginDate,endDate));
        return new StepBuilder("dailyReceiveStep",jobRepository)
                .tasklet(defaultTasklet,transactionManager).build();
    }

    @Bean
    @JobScope
    public Step dailyPaidIncreaseReceiveStep(JobRepository jobRepository
            , PaidIncreaseReceiveTasklet defaultTasklet
            , PlatformTransactionManager transactionManager) {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);
        log.info(String.format("%s ~ %s dailyPaidIncreaseReceiveStep 실행",beginDate,endDate));
        return new StepBuilder("dailyPaidIncreaseReceiveStep",jobRepository)
                .tasklet(defaultTasklet,transactionManager).build();
    }

}