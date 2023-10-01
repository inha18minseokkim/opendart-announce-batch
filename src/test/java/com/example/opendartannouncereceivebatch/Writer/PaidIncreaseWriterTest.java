package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.DTO.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Mapper.AnnouncePaidIncreaseMapper;
import com.example.opendartannouncereceivebatch.OpendartAnnouncereceiveBatchApplication;
import com.example.opendartannouncereceivebatch.Repository.AnnouncePaidIncreaseRepository;
import com.example.opendartannouncereceivebatch.Step.DefaultAnnouncementApiReceiveStepConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


import java.lang.reflect.InvocationTargetException;


@SpringBootTest(args = {"--beginDate=20230818","--endDate=20230818"})
@MockBean(classes = {DefaultAnnouncementApiReceiveStepConfig.class})
class PaidIncreaseWriterTest {
    @Autowired
    private AnnouncePaidIncreaseRepository announcePaidIncreaseRepository;

    @Test
    public void insertPaidIncreaseReport() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        AnnouncePaidIncreaseElement announcePaidIncreaseElement = AnnouncePaidIncreaseElement.builder()
                .rcept_no("20190221000921").corp_cls("K").corp_code("00378363")
                .corp_name("3S").nstk_ostk_cnt("376,265").nstk_estk_cnt("-")
                .fv_ps("500").bfic_tisstk_ostk("44,395,878").bfic_tisstk_estk("-")
                .fdpp_fclt("-").fdpp_bsninh("-").fdpp_op("783,393,850").fdpp_dtrp("-")
                .fdpp_ocsa("-").fdpp_etc("3,000,000").ic_mthn("제3자배정증자").ssl_at("-")
                .ssl_bgd("-").ssl_edd("-")
                .build();
        announcePaidIncreaseElement = (AnnouncePaidIncreaseElement) announcePaidIncreaseElement.getRefinedElement();
        System.out.println(announcePaidIncreaseElement);
        AnnouncePaidIncreaseMapper announcePaidIncreaseMapper = new AnnouncePaidIncreaseMapper();
        EssentialReport from = announcePaidIncreaseMapper.from(announcePaidIncreaseElement);
        System.out.println(from);

        announcePaidIncreaseRepository.save((AnnouncePaidIncrease) from);
    }
}