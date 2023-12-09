package com.example.opendartannouncereceivebatch;

import com.example.opendartannouncereceivebatch.CommonConfiguration.ObjectMapperConfig;
import com.example.opendartannouncereceivebatch.DTO.ListElement.AnnounceFreeIssueElement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = ObjectMapperConfig.class)
class ObjectMapperConfigTest {
    ObjectMapper objectMapper;

    @Autowired
    public ObjectMapperConfigTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    void freeIssueMappingTest() throws JsonProcessingException {
        String jsonString = "{\"rcept_no\":\"20231207000170\",\"corp_cls\":\"K\",\"corp_code\":\"00226547\",\"corp_name\":\"오상자이엘\",\"bddd\":\"2023년 12월 07일\",\"od_a_at_t\":\"-\",\"od_a_at_b\":\"1\",\"adt_a_atn\":\"참석\",\"nstk_ostk_cnt\":\"1,234,901\",\"nstk_estk_cnt\":\"-\",\"fv_ps\":\"500\",\"bfic_tisstk_ostk\":\"17,747,882\",\"bfic_tisstk_estk\":\"-\",\"nstk_asstd\":\"2024년 01월 01일\",\"nstk_ascnt_ps_ostk\":\"0.07\",\"nstk_ascnt_ps_estk\":\"-\",\"nstk_dividrk\":\"2024년 01월 01일\",\"nstk_dlprd\":\"-\",\"nstk_lstprd\":\"2024년 01월 22일\"}";
        log.info(jsonString);
        AnnounceFreeIssueElement announceFreeIssueElement = objectMapper.readValue(jsonString, AnnounceFreeIssueElement.class);
        log.info(announceFreeIssueElement.toString());
        Assertions.assertThat(announceFreeIssueElement.getRceptNo()).isEqualTo("20231207000170");
    }

}