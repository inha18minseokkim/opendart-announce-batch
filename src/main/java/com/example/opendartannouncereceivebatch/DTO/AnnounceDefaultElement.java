package com.example.opendartannouncereceivebatch.DTO;

import lombok.*;

import java.io.Serializable;
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnounceDefaultElement implements Serializable {
    //법인구분	    법인구분 : Y(유가), K(코스닥), N(코넥스), E(기타)
    private String corpCls;
    //종목명(법인명)	공시대상회사의 종목명(상장사) 또는 법인명(기타법인)
    private String corpName;
    //고유번호	    공시대상회사의 고유번호(8자리)
    private String corpCode;
    //종목코드	    상장회사의 종목코드(6자리)
    private String stockCode;
    //보고서명	    공시구분+보고서명+기타정보
    private String reportNm;
    //접수번호	    접수번호(14자리)
    private String rceptNo;
    //공시 제출인명	    공시 제출인명
    private String flrNm;
    //접수일자	    공시 접수일자(YYYYMMDD)
    private String rceptDt;
    //비고
    private String rm;
}
