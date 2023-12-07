package com.example.opendartannouncereceivebatch.DTO;

import com.example.opendartannouncereceivebatch.DTO.ListElement.AnnouncePaidIncreaseElement;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class AnnouncePaidIncreaseElementTest {
    @Test
    public void ElementTest() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
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
        announcePaidIncreaseElement = (AnnouncePaidIncreaseElement) announcePaidIncreaseElement.getRefinedElement();
        System.out.println(announcePaidIncreaseElement);
    }

}