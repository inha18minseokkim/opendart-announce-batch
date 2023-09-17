package com.example.opendartannouncereceivebatch.Step;

import com.example.opendartannouncereceivebatch.Reader.CorpCodeReaderImpl;
import com.example.opendartannouncereceivebatch.Repository.CorpInfoRepository;
import com.example.opendartannouncereceivebatch.Tasklet.DefaultAnnounceApiReceive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@Slf4j
public class DefaultAnnouncementApiReceiveStepConfig {

    @Bean
    public Job ExampleJob(JobRepository jobRepository,Step step){

        Job exampleJob = new JobBuilder("example",jobRepository).start(step).build();
        return exampleJob;
    }

//    @Bean
//    public Tasklet defaultTasklet(CorpInfoRepository corpInfoRepository, CorpCodeReaderImpl corpCodeReaderImpl) {
//        return new DefaultAnnounceApiReceive(corpInfoRepository,corpCodeReaderImpl);
//    }

    @Bean
    public Step myStep(JobRepository jobRepository, DefaultAnnounceApiReceive defaultTasklet, PlatformTransactionManager transactionManager) {
        return new StepBuilder("myStep",jobRepository)
                .tasklet(defaultTasklet,transactionManager).build();
    }

}
