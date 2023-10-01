package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Step.DefaultAnnouncementApiReceiveStepConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;


@SpringBootTest
@MockBean(classes = {DefaultAnnouncementApiReceiveStepConfig.class})
class CorpInfoRepositoryTest {
    @Autowired
    private CorpInfoRepository corpInfoRepository;

    @Test
    public void corpInfo_find() {
        List<CorpInfo> corpInfoList = corpInfoRepository.findAll();
        System.out.println(corpInfoList.size());
        //Assertions.assertNotEquals(corpInfoList.size(), 0);
    }
    @Test
    public void corpInfo_findByName() {
        List<String> corpNames = List.of("삼성전자","LG","SK하이닉스");
        List<CorpInfo> corpInfoList = corpNames.stream().map(corpInfoRepository::findFirstByCorpName)
                .filter(Optional::isPresent)
                .map(Optional::get).toList();
        System.out.println(corpInfoList.toString());
    }
}