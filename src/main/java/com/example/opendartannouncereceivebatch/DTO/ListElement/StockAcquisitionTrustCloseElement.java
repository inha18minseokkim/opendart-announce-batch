package com.example.opendartannouncereceivebatch.DTO.ListElement;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockAcquisitionTrustCloseElement implements EssentialResponseElement {
    private String rceptNo; //	접수번호
    private String corpCls; //	법인구분
    private String corpCode; //	고유번호
    private String corpName; //	회사명
    private String ctrPrcBfcc; //	계약금액(원)(해지 전)
    private String ctrPrcAtcc; //	계약금액(원)(해지 후)
    private String ctrPdBfccBgd; //	해지 전 계약기간(시작일)
    private String ctrPdBfccEdd; //	해지 전 계약기간(종료일)
    private String ccPp; //	해지목적
    private String ccInt; //	해지기관
    private String ccPrd; //	해지예정일자
    private String tpRmAtcc; //	해지후 신탁재산의 반환방법
    private String aqWtnDivOstk; //	해지 전 자기주식 보유현황(배당가능범위 내 취득(주)(보통주식))
    private String aqWtnDivOstkRt; //	해지 전 자기주식 보유현황(배당가능범위 내 취득(주)(비율(%)))
    private String aqWtnDivEstk; //	해지 전 자기주식 보유현황(배당가능범위 내 취득(주)(기타주식))
    private String aqWtnDivEstkRt; //	해지 전 자기주식 보유현황(배당가능범위 내 취득(주)(비율(%)))
    private String eaqOstk; //	해지 전 자기주식 보유현황(기타취득(주)(보통주식))
    private String eaqOstkRt; //	해지 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private String eaqEstk; //	해지 전 자기주식 보유현황(기타취득(주)(기타주식))
    private String eaqEstkRt; //	해지 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private String bddd; //	이사회결의일(결정일)
    private String odAAtT; //	사외이사참석여부(참석(명))
    private String odAAtB; //	사외이사참석여부(불참(명))
    private String adtAAtn; //	감사(사외이사가 아닌 감사위원)참석여부
}
