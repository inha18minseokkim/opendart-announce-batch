package com.example.opendartannouncereceivebatch.Step;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230818"})
class DefaultAnnouncementDefaultApiReceiveStepConfigTest {
    @Test
    public void idTest() {
        System.out.println(String.format("dailyReceiveJob:%s", LocalDateTime.now()));
    }
}