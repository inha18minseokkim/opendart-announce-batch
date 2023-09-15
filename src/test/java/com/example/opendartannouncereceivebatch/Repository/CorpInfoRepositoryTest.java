package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CorpInfoRepositoryTest {
    @Autowired
    private CorpInfoRepository corpInfoRepository;

    @Test
    public void corpInfo_find() {
        List<CorpInfo> corpInfoList = corpInfoRepository.findAll();
        System.out.println(corpInfoList.size());
        //Assertions.assertNotEquals(corpInfoList.size(), 0);
    }
}