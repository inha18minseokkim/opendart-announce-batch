package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.Business.EssentialApiReceive;
import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import com.example.opendartannouncereceivebatch.Reader.AnnounceDefaultReader;
import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
import org.junit.jupiter.api.Test;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230927"})
@MockBean(classes = {DefaultAnnouncementApiReceiveJobConfig.class})
class PaidIncreaseReceiveTaskletTest {
    @Autowired
    private ApplicationArguments applicationArguments;
    @Autowired
    private AnnounceDefaultReader announceDefaultReader;
    @Autowired
    private EssentialApiReceive essentialApiReceive;

    @Test
    @Transactional
    public void filterTest() {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);

        announceDefaultReader.getAnnounceList(beginDate, endDate)
                .filter((AnnounceDefault element) -> element.getReportNm().contains("증자"))
                .filter((AnnounceDefault element) -> element.getReportNm().contains("유상"))
                .filter((AnnounceDefault element) -> element.getReportNm().contains("주요사항"))
                        .forEach((element) -> {
            System.out.println(element.getReportNm());
        });

    }


    @Test
    @Transactional
    @Rollback(false)
    public void PaidIncreaseTaskletTest() throws Exception {
        String beginDate = applicationArguments.getOptionValues("beginDate").get(0);
        String endDate = applicationArguments.getOptionValues("endDate").get(0);
        System.out.println(beginDate);
        System.out.println(endDate);

        PaidIncreaseReceiveTasklet paidIncreaseReceiveTasklet = new PaidIncreaseReceiveTasklet(applicationArguments,announceDefaultReader,essentialApiReceive);
        RepeatStatus status = paidIncreaseReceiveTasklet.execute(null, null);

        // Assert the return status if necessary
        assertEquals(RepeatStatus.FINISHED, status);
    }

}