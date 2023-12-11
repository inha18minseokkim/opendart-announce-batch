package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AnnounceStockAcquisition implements EssentialReport{
    @Id
    private String rceptNo;	//접수번호
    private String corpCls;	//법인구분
    private String corpCode;	//고유번호
    private String corpName;	//회사명
    private String aqplnStkOstk;	//취득예정주식(주)(보통주식)
    private String aqplnStkEstk;	//취득예정주식(주)(기타주식)
    private String aqplnPrcOstk;	//취득예정금액(원)(보통주식)
    private String aqplnPrcEstk;	//취득예정금액(원)(기타주식)
    private String aqexpdBgd;	//취득예상기간(시작일)
    private String aqexpdEdd;	//취득예상기간(종료일)
    private String hdexpdBgd;	//보유예상기간(시작일)
    private String hdexpdEdd;	//보유예상기간(종료일)
    private String aqPp;	//취득목적
    private String aqMth;	//취득방법
    private String csIvBk;	//위탁투자중개업자
    private String aqWtnDivOstk;	//취득 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(보통주식))
    private String aqWtnDivOstkRt;	//취득 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(비율(%)))
    private String aqWtnDivEstk;	//취득 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(기타주식))
    private String aqWtnDivEstkRt;	//취득 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(비율(%)))
    private String eaqOstk;	//취득 전 자기주식 보유현황(기타취득(주)(보통주식))
    private String eaqOstkRt;	//취득 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private String eaqEstk;	//취득 전 자기주식 보유현황(기타취득(주)(기타주식))
    private String eaqEstkRt;	//취득 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private String aqDd;	//취득결정일
    private String odAAtT;	//사외이사참석여부(참석(명))
    private String odAAtB;	//사외이사참석여부(불참(명))
    private String adtAAtn;	//감사(사외이사가 아닌 감사위원)참석여부
    private String d1ProdlmOstk;	//1일 매수 주문수량 한도(보통주식)
    private String d1ProdlmEstk;	//1일 매수 주문수량 한도(기타주식)
}
