package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230818"})
@MockBean(classes = {DefaultAnnouncementApiReceiveJobConfig.class})
class AnnouncePaidIncreaseRepositoryTest {

    @Autowired
    AnnounceDefaultRepository announceDefaultRepository;
    @Test
    public void saveAnnounce() {

    }

}