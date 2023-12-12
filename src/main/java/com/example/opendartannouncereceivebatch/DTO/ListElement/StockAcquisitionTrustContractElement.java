package com.example.opendartannouncereceivebatch.DTO.ListElement;

public class StockAcquisitionTrustContractElement implements EssentialResponseElement {
    private String rceptNo; //	접수번호
    private String corpCls; //	법인구분
    private String corpCode; //	고유번호
    private String corpName; //	회사명
    private String ctrPrc; //	계약금액(원)
    private String ctrPdBgd; //	계약기간(시작일)
    private String ctrPdEdd; //	계약기간(종료일)
    private String ctrPp; //	계약목적
    private String ctrCnsInt; //	계약체결기관
    private String ctrCnsPrd; //	계약체결 예정일자
    private String aqWtnDivOstk; //	계약 전 자기주식 보유현황(배당가능범위 내 취득(주)(보통주식))
    private String aqWtnDivOstkRt; //	계약 전 자기주식 보유현황(배당가능범위 내 취득(주)(비율(%)))
    private String aqWtnDivEstk; //	계약 전 자기주식 보유현황(배당가능범위 내 취득(주)(기타주식))
    private String aqWtnDivEstkRt; //	계약 전 자기주식 보유현황(배당가능범위 내 취득(주)(비율(%)))
    private String eaqOstk; //	계약 전 자기주식 보유현황(기타취득(주)(보통주식))
    private String eaqOstkRt; //	계약 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private String eaqEstk; //	계약 전 자기주식 보유현황(기타취득(주)(기타주식))
    private String eaqEstkRt; //	계약 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private String bddd; //	이사회결의일(결정일)
    private String odAAtT; //	사외이사참석여부(참석(명))
    private String odAAtB; //	사외이사참석여부(불참(명))
    private String adtAAtn; //	감사(사외이사가 아닌 감사위원)참석여부
    private String csIvBk; //	위탁투자중개업자
}
