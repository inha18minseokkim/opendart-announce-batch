package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


@Entity(name = "announceDefault")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnounceDefault {

    @jakarta.persistence.Id
    @Id
    private Long id;
    @Column(name = "corp_cls")	//법인구분	    법인구분 : Y(유가), K(코스닥), N(코넥스), E(기타)
    private String corpClass;
    @Column(name = "corp_name") //종목명(법인명)	공시대상회사의 종목명(상장사) 또는 법인명(기타법인)
    private String corpName;
    @Column(name = "corp")      //고유번호	    공시대상회사의 고유번호(8자리)
    private String corpCode;
    @Column(name = "stockCode") //종목코드	    상장회사의 종목코드(6자리)
    private String stockCode;
    @Column(name = "report_nm") //보고서명	    공시구분+보고서명+기타정보
    private String reportName;
    @Column(name = "rcept_no")  //접수번호	    접수번호(14자리)
    private String receptNumber;
    @Column(name = "flr_nm")    //공시 제출인명	    공시 제출인명
    private String submitterName;
    @Column(name = "rcept_dt")  //접수일자	    공시 접수일자(YYYYMMDD)
    private LocalDate receptDate;
    @Column(name = "rm")        //비고
    private String room;



}