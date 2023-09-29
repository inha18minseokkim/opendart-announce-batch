package com.example.opendartannouncereceivebatch.DTO;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class AnnouncePaidIncreaseElementTest {
    @Test
    public void ElementTest() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        AnnouncePaidIncreaseElement announcePaidIncreaseElement = AnnouncePaidIncreaseElement.builder()
                .rcept_no("20190221000921").corp_cls("K").corp_code("00378363")
                .corp_name("3S").nstk_ostk_cnt("376,265").nstk_estk_cnt("-")
                .fv_ps("500").bfic_tisstk_ostk("44,395,878").bfic_tisstk_estk("-")
                .fdpp_fclt("-").fdpp_bsninh("-").fdpp_op("783,393,850").fdpp_dtrp("-")
                .fdpp_ocsa("-").fdpp_etc("3,000,000").ic_mthn("제3자배정증자").ssl_at("-")
                .ssl_bgd("-").ssl_edd("-")
                .build();
        System.out.println(announcePaidIncreaseElement);
        announcePaidIncreaseElement = (AnnouncePaidIncreaseElement) announcePaidIncreaseElement.getRefinedElement();
        System.out.println(announcePaidIncreaseElement);
    }

}