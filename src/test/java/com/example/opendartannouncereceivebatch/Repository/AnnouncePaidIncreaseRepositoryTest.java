package com.example.opendartannouncereceivebatch.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230818"})
class AnnouncePaidIncreaseRepositoryTest {

    @Autowired
    AnnounceDefaultRepository announceDefaultRepository;
    @Test
    public void saveAnnounce() {

    }

}