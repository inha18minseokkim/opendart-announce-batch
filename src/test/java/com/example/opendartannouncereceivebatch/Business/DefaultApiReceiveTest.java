package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultResponse;
import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Reader.CorpCodeReaderTestImpl;
import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
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
class DefaultApiReceiveTest {
    @Autowired
    private DefaultApiReceive defaultApiReceive;
    @Test
    public void receive_api() {
        CorpInfo corpInfo = CorpInfo.builder().corp_name("삼성전자").corp_code("005930").stock_code("005930").build();
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