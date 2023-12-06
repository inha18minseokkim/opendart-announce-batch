package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.Code.AnnounceKindCode;
import com.example.opendartannouncereceivebatch.DTO.ListElement.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Mapper.AnnouncePaidIncreaseMapper;
import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230818"})
@MockBean(classes = {DefaultAnnouncementApiReceiveJobConfig.class})
class EssentialApiReceiveTest {
    @Autowired
    private EssentialApiReceive essentialApiReceive;
    @Test
    public void paidIncreaseApiReceive() {
        Stream<?> essentialAnnouncement = essentialApiReceive.getEssentialAnnouncement("20190101", "20191231", "00378363", AnnounceKindCode.PAID_INCREASE);
        essentialAnnouncement.forEach((object) -> {
            System.out.println(object.toString());
            System.out.println(object.getClass());
            assertEquals(object.getClass(),AnnounceKindCode.PAID_INCREASE.getResponseClass());
        });
    }

    @Test
    public void paidIncreaseSaveTest() {
        AnnouncePaidIncreaseElement announcePaidIncreaseElement = AnnouncePaidIncreaseElement.builder()
                .rcept_no("20190221000921").corp_cls("K").corp_code("00378363")
                .corp_name("3S").nstk_ostk_cnt("376,265").nstk_estk_cnt("-")
                .fv_ps("500").bfic_tisstk_ostk("44,395,878").bfic_tisstk_estk("-")
                .fdpp_fclt("-").fdpp_bsninh("-").fdpp_op("783,393,850").fdpp_dtrp("-")
                .fdpp_ocsa("-").fdpp_etc("3,000,000").ic_mthn("제3자배정증자").ssl_at("-")
                .ssl_bgd("-").ssl_edd("-")
                .build();
        System.out.println(announcePaidIncreaseElement);
//        AnnouncePaidIncreaseMapper announcePaidIncreaseMapper = new AnnouncePaidIncreaseMapper();
//
//        Stream<? extends EssentialReport> essentialAnnouncement = Stream.of(announcePaidIncreaseElement)
//                .map(announcePaidIncreaseMapper::from);
//        Integer integer = essentialApiReceive.saveRepository(essentialAnnouncement, AnnounceKindCode.PAID_INCREASE);
//        System.out.println(integer);
    }
}