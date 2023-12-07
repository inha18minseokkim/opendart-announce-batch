package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Entity(name = "corp_common_announce")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class AnnounceDefault {

    @Id
    @Column(unique = true)
    private Long rceptNo;//접수번호	    접수번호(14자리)
    private String corpCls;//법인구분	    법인구분 : Y(유가), K(코스닥), N(코넥스), E(기타)
    private String corpName;//종목명(법인명)	공시대상회사의 종목명(상장사) 또는 법인명(기타법인)
    private String corpCode;//고유번호	    공시대상회사의 고유번호(8자리)
    private String stockCode;//종목코드	    상장회사의 종목코드(6자리)
    private String reportNm;//보고서명	    공시구분+보고서명+기타정보
    private String flrNm;//공시 제출인명	    공시 제출인명
    private LocalDate rceptDt;//접수일자	    공시 접수일자(YYYYMMDD)
    private String rm;//비고
}