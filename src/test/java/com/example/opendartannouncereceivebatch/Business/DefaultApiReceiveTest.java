package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultResponse;
import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Reader.CorpCodeReaderTestImpl;
import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@MockBean(classes = {DefaultAnnouncementApiReceiveJobConfig.class})
@Slf4j
class DefaultApiReceiveTest {
    @Autowired
    private DefaultApiReceive defaultApiReceive;
    @Test
    public void receive_api() {
        CorpInfo corpInfo = CorpInfo.builder().corpName("삼성전자")
                .corpCode("005930").stockCode("005930").build();
        Mono<AnnounceDefaultResponse> result = defaultApiReceive.getCurrentCorpAnnounce(Optional.of(corpInfo),"20230101","20230915",1);
        log.info("@@");
        AnnounceDefaultResponse tempResponse = result.block();
        log.info(""+tempResponse);
        tempResponse.getList().forEach((element) -> log.info(element.toString()));

    }

    @Autowired
    private CorpCodeReaderTestImpl corpCodeReaderTest;
    @Test
    public void receive_api_list() {
        List<String> corpNameList = List.of("삼성전자");
        Stream<AnnounceDefaultElement> announcementList = defaultApiReceive.
                getAnnouncementList(corpCodeReaderTest, corpNameList,"20230810","20230915");
        log.info(""+announcementList.collect(Collectors.toList()).size());

    }
    @Test
    public void receive_daily_list() {
        Stream<AnnounceDefaultElement> announcementList = defaultApiReceive.getAnnouncementList("20230918", "20230918");
        //announcementList.forEach(System.out::println);
        log.info(""+announcementList.collect(Collectors.toList()).size());
    }
}