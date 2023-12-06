package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.ListElement.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EssentialMapperTest {
    @Test
    void mappingTest() throws IllegalAccessException, InstantiationException {
        AnnouncePaidIncreaseElement announcePaidIncreaseElement = AnnouncePaidIncreaseElement.builder()
                .rcept_no("20190221000921").corp_cls("K").corp_code("00378363")
                .corp_name("3S").nstk_ostk_cnt("376,265").nstk_estk_cnt("-")
                .fv_ps("500").bfic_tisstk_ostk("44,395,878").bfic_tisstk_estk("-")
                .fdpp_fclt("-").fdpp_bsninh("-").fdpp_op("783,393,850").fdpp_dtrp("-")
                .fdpp_ocsa("-").fdpp_etc("3,000,000").ic_mthn("제3자배정증자").ssl_at("-")
                .ssl_bgd("-").ssl_edd("-")
                .build();
        AnnouncePaidIncrease announcePaidIncrease = EssentialMapper.mapObjects(announcePaidIncreaseElement.getRefinedElement(), AnnouncePaidIncrease.class);
        log.info(announcePaidIncrease.toString());
        Assertions.assertThat(announcePaidIncrease.getCorp_code()).isEqualTo(announcePaidIncreaseElement.getCorp_code());
        Assertions.assertThat(announcePaidIncrease.getNstk_ostk_cnt()).isEqualTo(376265);
        Assertions.assertThat(announcePaidIncrease.getBfic_tisstk_ostk()).isEqualTo(44395878);
        Assertions.assertThat(announcePaidIncrease.getSsl_edd()).isNull();
        Assertions.assertThat(announcePaidIncrease.getNstk_estk_cnt()).isNull();
        Assertions.assertThat(announcePaidIncrease.getFdpp_fclt()).isNull();
    }

}