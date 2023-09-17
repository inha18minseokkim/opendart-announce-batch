package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultResponse;
import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.List;


@SpringBootTest
class DefaultAnnounceApiReceiveTest {
    @Autowired
    private DefaultAnnounceApiReceive defaultAnnounceApiReceive;

    @Test
    public void receive_api() {
        CorpInfo corpInfo = CorpInfo.builder().corpName("삼성전자").corpCode("005930").stockCode("005930").build();
        Mono<AnnounceDefaultResponse> result = defaultAnnounceApiReceive.getCurrentCorpAnnounce(corpInfo,"20230101","20230915");
        System.out.println("@@");
        AnnounceDefaultResponse tempResponse = result.block();
        System.out.println(tempResponse);
        tempResponse.getList().forEach(System.out::println);

    }

}