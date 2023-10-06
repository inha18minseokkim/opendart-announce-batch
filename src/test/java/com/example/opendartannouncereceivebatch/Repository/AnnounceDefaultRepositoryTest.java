package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230818"})
@MockBean(classes = {DefaultAnnouncementApiReceiveJobConfig.class})
class AnnounceDefaultRepositoryTest {

    @Autowired
    private AnnounceDefaultRepository announceDefaultRepository;

    @Test
    public void announce_test() {
        List<AnnounceDefault> announceDefaultList = announceDefaultRepository.findAll();
        System.out.println(announceDefaultList.size());
        assertNotEquals(announceDefaultList.size(),0);
    }

    @Test
    @Transactional
    public void announceBetweenDateTest() {
        LocalDate startDate = LocalDate.of(2023,9,10);
        LocalDate endDate = LocalDate.of(2023,9,20);
        announceDefaultRepository.findByReceptDateBetween(startDate,endDate).forEach(System.out::println);

    }

}