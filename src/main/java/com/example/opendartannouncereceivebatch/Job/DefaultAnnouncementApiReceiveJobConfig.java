package com.example.opendartannouncereceivebatch.Job;

import com.example.opendartannouncereceivebatch.Tasklet.DailyAnnounceApiReceiveTasklet;
import com.example.opendartannouncereceivebatch.Tasklet.FreeIssueReceiveTasklet;
import com.example.opendartannouncereceivebatch.Tasklet.PaidIncreaseReceiveTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.LocalDateTime;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class DefaultAnnouncementApiReceiveJobConfig {
    private final DailyAnnounceApiReceiveTasklet dailyAnnounceApiReceiveTasklet;
    private final PaidIncreaseReceiveTasklet paidIncreaseReceiveTasklet;
    private final FreeIssueReceiveTasklet freeIssueReceiveTasklet;
    private final ApplicationArguments applicationArguments;
    private final JobRepository jobRepository;
    @Value("${beginDate}")
    private String beginDate;
    @Value("${endDate}")
    private String endDate;
    @Bean
    public JobParameters jobParameters() {
        return new JobParametersBuilder().addString("beginDate",beginDate)
                .addString("endDate",endDate)
                .addLong("executeDateTime", System.currentTimeMillis())
                .toJobParameters();
    }
    @Bean
    public JobExecution jobExecution(JobRepository jobRepository,PlatformTransactionManager transactionManager) throws Exception {
        return dailyJobLauncher(jobRepository).run(
                dailyReceiveJob(jobRepository,transactionManager)
                ,jobParameters());
    }
    @Bean
    public JobLauncher dailyJobLauncher(JobRepository jobRepository) throws Exception {
        TaskExecutorJobLauncher taskExecutorJobLauncher = new TaskExecutorJobLauncher();
        taskExecutorJobLauncher.setJobRepository(jobRepository);
        taskExecutorJobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        //taskExecutorJobLauncher.afterPropertiesSet();
        return taskExecutorJobLauncher;
    }

    @Bean
    public Job dailyReceiveJob(JobRepository jobRepository,
                               PlatformTransactionManager transactionManager){

        log.info(String.format("dailyReceiveJob 실행 시작 %s ~ %s",beginDate,endDate));

        Job exampleJob = new JobBuilder("dailyReceiveJob",jobRepository)
                .start(dailyReceiveStep(jobRepository,dailyAnnounceApiReceiveTasklet,transactionManager))
                .next(dailyPaidIncreaseReceiveStep(jobRepository, paidIncreaseReceiveTasklet, transactionManager))
                .next(dailyFreeIssueReceiveStep(jobRepository,freeIssueReceiveTasklet,transactionManager))
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

    @Bean
    @JobScope
    public Step dailyFreeIssueReceiveStep(JobRepository jobRepository
    , FreeIssueReceiveTasklet defaultTasklet
    , PlatformTransactionManager transactionManager) {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);
        log.info(String.format("%s ~ %s dailyFreeIssueReceiveStep 실행",beginDate,endDate));
        return new StepBuilder("dailyFreeIssueReceiveStep",jobRepository)
                .tasklet(defaultTasklet,transactionManager).build();
    }

}
