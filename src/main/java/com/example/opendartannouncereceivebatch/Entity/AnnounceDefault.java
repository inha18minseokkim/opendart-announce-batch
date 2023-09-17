package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


@Entity(name = "CorpCommonAnnouncement")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AnnounceDefault {

    @jakarta.persistence.Id
    @Id
    private Long id;
    private String corpClass;       //법인구분	    법인구분 : Y(유가), K(코스닥), N(코넥스), E(기타)
    private String corpName;        //종목명(법인명)	공시대상회사의 종목명(상장사) 또는 법인명(기타법인)
    private String corpCode;        //고유번호	    공시대상회사의 고유번호(8자리)
    private String stockCode;       //종목코드	    상장회사의 종목코드(6자리)
    private String reportName;      //보고서명	    공시구분+보고서명+기타정보
    private String receptNumber;    //접수번호	    접수번호(14자리)
    private String submitterName;   //공시 제출인명	    공시 제출인명
    private LocalDate receptDate;   //접수일자	    공시 접수일자(YYYYMMDD)
    private String room;            //비고



}