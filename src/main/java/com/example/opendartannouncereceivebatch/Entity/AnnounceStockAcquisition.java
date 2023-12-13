package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class AnnounceStockAcquisition implements EssentialReport{
    @Id
    private String rceptNo;	//접수번호
    private String corpCls;	//법인구분
    private String corpCode;	//고유번호
    private String corpName;	//회사명
    private Long aqplnStkOstk;	//취득예정주식(주)(보통주식)
    private Long aqplnStkEstk;	//취득예정주식(주)(기타주식)
    private Long aqplnPrcOstk;	//취득예정금액(원)(보통주식)
    private Long aqplnPrcEstk;	//취득예정금액(원)(기타주식)
    private LocalDate aqexpdBgd;	//취득예상기간(시작일)
    private LocalDate aqexpdEdd;	//취득예상기간(종료일)
    private LocalDate hdexpdBgd;	//보유예상기간(시작일)
    private LocalDate hdexpdEdd;	//보유예상기간(종료일)
    @Column(length=1000)
    private String aqPp;	//취득목적
    @Column(length=1000)
    private String aqMth;	//취득방법
    private String csIvBk;	//위탁투자중개업자
    private Long aqWtnDivOstk;	//취득 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(보통주식))
    private Double aqWtnDivOstkRt;	//취득 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(비율(%)))
    private Long aqWtnDivEstk;	//취득 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(기타주식))
    private Double aqWtnDivEstkRt;	//취득 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(비율(%)))
    private Long eaqOstk;	//취득 전 자기주식 보유현황(기타취득(주)(보통주식))
    private Double eaqOstkRt;	//취득 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private Long eaqEstk;	//취득 전 자기주식 보유현황(기타취득(주)(기타주식))
    private Double eaqEstkRt;	//취득 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private LocalDate aqDd;	//취득결정일
    private Long odAAtT;	//사외이사참석여부(참석(명))
    private Long odAAtB;	//사외이사참석여부(불참(명))
    private String adtAAtn;	//감사(사외이사가 아닌 감사위원)참석여부
    private Long d1ProdlmOstk;	//1일 매수 주문수량 한도(보통주식)
    private Long d1ProdlmEstk;	//1일 매수 주문수량 한도(기타주식)
}
