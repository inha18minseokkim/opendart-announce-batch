package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultResponse;
import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Reader.CorpCodeReaderTestImpl;
import com.example.opendartannouncereceivebatch.Tasklet.DefaultAnnounceApiReceive;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiReceiveTest {
    @Autowired
    private ApiReceive apiReceive;

    @Test
    public void receive_api() {
        CorpInfo corpInfo = CorpInfo.builder().corpName("삼성전자").corpCode("005930").stockCode("005930").build();
        Mono<AnnounceDefaultResponse> result = apiReceive.getCurrentCorpAnnounce(Optional.of(corpInfo),"20230101","20230915",1);
        System.out.println("@@");
        AnnounceDefaultResponse tempResponse = result.block();
        System.out.println(tempResponse);
        tempResponse.getList().forEach(System.out::println);

    }

    @Autowired
    private CorpCodeReaderTestImpl corpCodeReaderTest;
    @Test
    public void receive_api_list() {
        List<String> corpNameList = List.of("삼성전자");
        List<AnnounceDefaultElement> announcementList = apiReceive.
                getAnnouncementList(corpCodeReaderTest, corpNameList,"20230810","20230915");
        System.out.println(announcementList.size());

    }
    @Test
    public void receive_daily_list() {
        List<AnnounceDefaultElement> announcementList = apiReceive.getAnnouncementList("20230915", "20230915");
        System.out.println(announcementList.size());
    }

}