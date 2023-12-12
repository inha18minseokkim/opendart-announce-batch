package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.Code.AnnounceKindCode;
import com.example.opendartannouncereceivebatch.DTO.ListElement.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.DTO.ListElement.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Mapper.AnnouncePaidIncreaseMapper;
import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230818"})
@MockBean(classes = {DefaultAnnouncementApiReceiveJobConfig.class})
@Slf4j
class EssentialApiReceiveTest {
    @Autowired
    private EssentialApiReceive essentialApiReceive;
    @Test
    public void paidIncreaseApiReceive() {
        Stream<?> essentialAnnouncement = essentialApiReceive.getEssentialAnnouncement("20190101", "20191231", "00378363", AnnounceKindCode.PAID_INCREASE);
        essentialAnnouncement.forEach((object) -> {
            log.info(object.toString());
            log.info(""+object.getClass());
            assertEquals(object.getClass(),AnnounceKindCode.PAID_INCREASE.getResponseClass());
        });
    }
    @Test
    public void freeIssueApiReceive() {
        Stream<?> essentialAnnouncement = essentialApiReceive.getEssentialAnnouncement("20231207", "20231207", "00226547", AnnounceKindCode.FREE_ISSUE);
        essentialAnnouncement.forEach((object) -> {
            log.info(object.toString());
            log.info(""+object.getClass());
            assertEquals(object.getClass(),AnnounceKindCode.PAID_INCREASE.getResponseClass());
        });
    }
    @Test
    public void stockDispositionTest() {
        Stream<? extends EssentialResponseElement> essentialAnnouncement = essentialApiReceive.getEssentialAnnouncement("20231212", "20231212", "00221728", AnnounceKindCode.STOCK_DISPOSITION);
        essentialAnnouncement.forEach((element) -> {log.info(element.toString());});
    }

    @Test
    public void paidIncreaseSaveTest() {
        AnnouncePaidIncreaseElement announcePaidIncreaseElement = AnnouncePaidIncreaseElement.builder()
                .rceptNo("20190221000921").corpCls("K")
                        .corpCode("00378363")
                        .corpName("3S").nstkOstkCnt("376,265").nstkEstkCnt("")
                .fvPs("500").bficTisstkOstk("44,395,878")
                .bficTisstkEstk("").fdppFclt("")
                .fdppBsninh("")
                .fdppOp("783,393,850").fdppDtrp("")
                .fdppOcsa("").fdppEtc("3,000,000").icMthn("제3자배정증자")
                .sslAt("")
                .sslBgd("").sslEdd("").build();
        System.out.println(announcePaidIncreaseElement);
//        AnnouncePaidIncreaseMapper announcePaidIncreaseMapper = new AnnouncePaidIncreaseMapper();
//
//        Stream<? extends EssentialReport> essentialAnnouncement = Stream.of(announcePaidIncreaseElement)
//                .map(announcePaidIncreaseMapper::from);
//        Integer integer = essentialApiReceive.saveRepository(essentialAnnouncement, AnnounceKindCode.PAID_INCREASE);
//        System.out.println(integer);
    }
}