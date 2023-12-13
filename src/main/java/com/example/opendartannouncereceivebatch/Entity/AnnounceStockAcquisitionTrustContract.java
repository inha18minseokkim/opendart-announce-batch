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
public class AnnounceStockAcquisitionTrustContract implements EssentialReport{
    @Id
    private String rceptNo; //	접수번호
    private String corpCls; //	법인구분
    private String corpCode; //	고유번호
    private String corpName; //	회사명
    private Long ctrPrc; //	계약금액(원)
    private LocalDate ctrPdBgd; //	계약기간(시작일)
    private LocalDate ctrPdEdd; //	계약기간(종료일)
    @Column(length=1000)
    private String ctrPp; //	계약목적
    private String ctrCnsInt; //	계약체결기관
    private LocalDate ctrCnsPrd; //	계약체결 예정일자
    private Long aqWtnDivOstk; //	계약 전 자기주식 보유현황(배당가능범위 내 취득(주)(보통주식))
    private Double aqWtnDivOstkRt; //	계약 전 자기주식 보유현황(배당가능범위 내 취득(주)(비율(%)))
    private Long aqWtnDivEstk; //	계약 전 자기주식 보유현황(배당가능범위 내 취득(주)(기타주식))
    private Double aqWtnDivEstkRt; //	계약 전 자기주식 보유현황(배당가능범위 내 취득(주)(비율(%)))
    private Long eaqOstk; //	계약 전 자기주식 보유현황(기타취득(주)(보통주식))
    private Double eaqOstkRt; //	계약 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private Long eaqEstk; //	계약 전 자기주식 보유현황(기타취득(주)(기타주식))
    private Double eaqEstkRt; //	계약 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private LocalDate bddd; //	이사회결의일(결정일)
    private Long odAAtT; //	사외이사참석여부(참석(명))
    private Long odAAtB; //	사외이사참석여부(불참(명))
    private String adtAAtn; //	감사(사외이사가 아닌 감사위원)참석여부
    private String csIvBk; //	위탁투자중개업자
}
