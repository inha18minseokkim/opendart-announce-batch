package com.example.opendartannouncereceivebatch.DTO.ListElement;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDispositionElement implements EssentialResponseElement{
    private String rceptNo;	//접수번호
    private String corpCls;	//법인구분
    private String corpCode;	//고유번호
    private String corpName;	//회사명
    private String dpplnStkOstk;	//처분예정주식(주)(보통주식)
    private String dpplnStkEstk;	//처분예정주식(주)(기타주식)
    private String dpstkPrcOstk;	//처분 대상 주식가격(원)(보통주식)
    private String dpstkPrcEstk;	//처분 대상 주식가격(원)(기타주식)
    private String dpplnPrcOstk;	//처분예정금액(원)(보통주식)
    private String dpplnPrcEstk;	//처분예정금액(원)(기타주식)
    private String dpprpdBgd;	//처분예정기간(시작일)
    private String dpprpdEdd;	//처분예정기간(종료일)
    private String dpPp;	//처분목적
    private String dpMMkt;	//처분방법(시장을 통한 매도(주))
    private String dpMOvtm;	//처분방법(시간외대량매매(주))
    private String dpMOtc;	//처분방법(장외처분(주))
    private String dpMEtc;	//처분방법(기타(주))
    private String csIvBk;	//위탁투자중개업자
    private String aqWtnDivOstk;	//처분 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(보통주식))
    private String aqWtnDivOstkRt;	//처분 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(비율(%)))
    private String aqWtnDivEstk;	//처분 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(기타주식))
    private String aqWtnDivEstkRt;	//처분 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(비율(%)))
    private String eaqOstk;	//처분 전 자기주식 보유현황(기타취득(주)(보통주식))
    private String eaqOstkRt;	//처분 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private String eaqEstk;	//처분 전 자기주식 보유현황(기타취득(주)(기타주식))
    private String eaqEstkRt;	//처분 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private String dpDd;	//처분결정일
    private String odAAtT;	//사외이사참석여부(참석(명))
    private String odAAtB;	//사외이사참석여부(불참(명))
    private String adtAAtn;	//감사(사외이사가 아닌 감사위원)참석여부
    private String d1SlodlmOstk;	//1일 매도 주문수량 한도(보통주식)
    private String d1SlodlmEstk;	//1일 매도 주문수량 한도(기타주식)
}
