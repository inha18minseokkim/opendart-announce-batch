package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.Code.AnnounceKindCode;
import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultResponse;
import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Reader.CorpCodeReaderTestImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class DefaultApiReceiveTest {
    @Autowired
    private DefaultApiReceive defaultApiReceive;
    @Test
    public void receive_api() {
        CorpInfo corpInfo = CorpInfo.builder().corpName("삼성전자").corpCode("005930").stockCode("005930").build();
        Mono<AnnounceDefaultResponse> result = defaultApiReceive.getCurrentCorpAnnounce(Optional.of(corpInfo),"20230101","20230915",1);
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
        Stream<AnnounceDefaultElement> announcementList = defaultApiReceive.
                getAnnouncementList(corpCodeReaderTest, corpNameList,"20230810","20230915");
        System.out.println(announcementList.collect(Collectors.toList()).size());

    }
    @Test
    public void receive_daily_list() {
        Stream<AnnounceDefaultElement> announcementList = defaultApiReceive.getAnnouncementList("20230918", "20230918");
        //announcementList.forEach(System.out::println);
        System.out.println(announcementList.collect(Collectors.toList()).size());
    }
}