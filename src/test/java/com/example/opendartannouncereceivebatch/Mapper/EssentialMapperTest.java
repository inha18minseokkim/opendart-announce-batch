package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.ListElement.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.DTO.ListElement.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
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
        EssentialMapper essentialMapper = new EssentialMapper() {
            @Override
            public EssentialReport from(EssentialResponseElement element) {
                return EssentialMapper.super.from(element);
            }

            @Override
            public <S, T> T mapObjects(S source, Class<T> targetType) throws IllegalAccessException, InstantiationException {
                return EssentialMapper.super.mapObjects(source, targetType);
            }

            @Override
            public Object convert(Object value, Class<?> targetType) {
                return EssentialMapper.super.convert(value, targetType);
            }
        };
        AnnouncePaidIncrease announcePaidIncrease = essentialMapper.mapObjects(announcePaidIncreaseElement.getRefinedElement(), AnnouncePaidIncrease.class);
        log.info(announcePaidIncrease.toString());
        Assertions.assertThat(announcePaidIncrease.getCorpCode()).isEqualTo(announcePaidIncreaseElement.getCorpCode());
        Assertions.assertThat(announcePaidIncrease.getNstkOstkCnt()).isEqualTo(376265);
        Assertions.assertThat(announcePaidIncrease.getBficTisstkOstk()).isEqualTo(44395878);
        Assertions.assertThat(announcePaidIncrease.getSslEdd()).isNull();
        Assertions.assertThat(announcePaidIncrease.getNstkEstkCnt()).isNull();
        Assertions.assertThat(announcePaidIncrease.getFdppFclt()).isNull();
    }

}