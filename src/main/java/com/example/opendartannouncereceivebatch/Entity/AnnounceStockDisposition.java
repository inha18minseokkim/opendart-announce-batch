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
public class AnnounceStockDisposition implements EssentialReport{
    @Id
    private String rceptNo;	//접수번호
    private String corpCls;	//법인구분
    private String corpCode;	//고유번호
    private String corpName;	//회사명
    private Long dpplnStkOstk;	//처분예정주식(주)(보통주식)
    private Long dpplnStkEstk;	//처분예정주식(주)(기타주식)
    private Long dpstkPrcOstk;	//처분 대상 주식가격(원)(보통주식)
    private Long dpstkPrcEstk;	//처분 대상 주식가격(원)(기타주식)
    private Long dpplnPrcOstk;	//처분예정금액(원)(보통주식)
    private Long dpplnPrcEstk;	//처분예정금액(원)(기타주식)
    private LocalDate dpprpdBgd;	//처분예정기간(시작일)
    private LocalDate dpprpdEdd;	//처분예정기간(종료일)
    @Column(length=1000)
    private String dpPp;	//처분목적
    private Long dpMMkt;	//처분방법(시장을 통한 매도(주))
    private Long dpMOvtm;	//처분방법(시간외대량매매(주))
    private Long dpMOtc;	//처분방법(장외처분(주))
    private Long dpMEtc;	//처분방법(기타(주))
    private String csIvBk;	//위탁투자중개업자
    private Long aqWtnDivOstk;	//처분 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(보통주식))
    private Double aqWtnDivOstkRt;	//처분 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(비율(%)))
    private Long aqWtnDivEstk;	//처분 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(기타주식))
    private Double aqWtnDivEstkRt;	//처분 전 자기주식 보유현황(배당가능이익 범위 내 취득(주)(비율(%)))
    private Long eaqOstk;	//처분 전 자기주식 보유현황(기타취득(주)(보통주식))
    private Double eaqOstkRt;	//처분 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private Long eaqEstk;	//처분 전 자기주식 보유현황(기타취득(주)(기타주식))
    private Double eaqEstkRt;	//처분 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private LocalDate dpDd;	//처분결정일
    private Long odAAtT;	//사외이사참석여부(참석(명))
    private Long odAAtB;	//사외이사참석여부(불참(명))
    private String adtAAtn;	//감사(사외이사가 아닌 감사위원)참석여부
    private Long d1SlodlmOstk;	//1일 매도 주문수량 한도(보통주식)
    private Long d1SlodlmEstk;	//1일 매도 주문수량 한도(기타주식)
}
