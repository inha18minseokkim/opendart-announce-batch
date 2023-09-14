package com.example.opendartannouncereceivebatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class OpendartAnnouncereceiveBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpendartAnnouncereceiveBatchApplication.class, args);
    }

}
