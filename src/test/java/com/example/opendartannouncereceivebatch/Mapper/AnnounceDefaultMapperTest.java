package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import com.example.opendartannouncereceivebatch.Job.DefaultAnnouncementApiReceiveJobConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@MockBean(classes = {DefaultAnnouncementApiReceiveJobConfig.class})
class AnnounceDefaultMapperTest {

    @Autowired
    AnnounceDefaultMapper announceDefaultMapper;

    @Test
    public void stringToLocalDate() {
        LocalDate tempLocalDate = LocalDate.parse("20230814", DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(tempLocalDate);
    }
    @Test
    public void defaultMappingTest(){

        //{"corp_code":"00126380","corp_name":"삼성전자","stock_code":"005930","corp_cls":"Y",
        // "report_nm":"동일인등출자계열회사와의상품ㆍ용역거래변경","rcept_no":"20230814001577","flr_nm":"삼성전자","rcept_dt":"20230814","rm":"공"}
        AnnounceDefaultElement testObject = AnnounceDefaultElement.builder()
                .corpCode("00126380").corpName("삼성전자")
                .stockCode("005930").corpCls("Y")
                .reportNm("동일인등출자계열회사와의상품ㆍ용역거래변경")
                .rceptNo("20230814001577").flrNm("삼성전자")
                .rceptDt("20230814").rm("공").build();
        AnnounceDefault announceDefault = announceDefaultMapper.from(testObject);
        System.out.println(announceDefault.toString());

    }
}