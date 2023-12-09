package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefaultPageInfo;
import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@SpringBootTest
@MockBean(classes = {DefaultAnnouncementApiReceiveJobConfig.class})
class AnnounceDefaultPageInfoRepositoryTest {
    @Autowired
    AnnounceDefaultPageInfoRepository repository;
    @BeforeEach
    void createTest (){
        AnnounceDefaultPageInfo announceDefaultPageInfo = AnnounceDefaultPageInfo.builder().rceptDt(LocalDate.of(2023,12,9)).currentCount(1).build();
        repository.save(announceDefaultPageInfo);
    }
    @AfterEach
    void deleteTest() {
        AnnounceDefaultPageInfo announceDefaultPageInfo = AnnounceDefaultPageInfo.builder().rceptDt(LocalDate.of(2023,12,9)).currentCount(1).build();
        repository.delete(announceDefaultPageInfo);
    }
    @Test
    void extractTest() {
        AnnounceDefaultPageInfo announceDefaultPageInfo = repository.findByRceptDt(LocalDate.of(2023, 12, 9)).orElseThrow();
        Assertions.assertThat(announceDefaultPageInfo.getCurrentCount()).isEqualTo(1);
    }

}