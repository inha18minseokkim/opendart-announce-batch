package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.Code.AnnounceKindCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {EssentialApiReceive.class})
class EssentialApiReceiveTest {
    @Autowired
    private EssentialApiReceive essentialApiReceive;
    @Test
    public void paidIncreaseApiReceive() {
        Stream<?> essentialAnnouncement = essentialApiReceive.getEssentialAnnouncement("20190101", "20191231", "00378363", AnnounceKindCode.PAIDINCREASE);
        essentialAnnouncement.forEach((object) -> {
            System.out.println(object.toString());
            System.out.println(object.getClass());
            assertEquals(object.getClass(),AnnounceKindCode.PAIDINCREASE.getResponseClass());
        });
    }
}