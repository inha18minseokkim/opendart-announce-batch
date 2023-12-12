package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class AnnounceStockAcquisitionTrustClose implements EssentialReport{
    @Id
    private String rceptNo; //	접수번호
    private String corpCls; //	법인구분
    private String corpCode; //	고유번호
    private String corpName; //	회사명
    private Long ctrPrcBfcc; //	계약금액(원)(해지 전)
    private Long ctrPrcAtcc; //	계약금액(원)(해지 후)
    private LocalDate ctrPdBfccBgd; //	해지 전 계약기간(시작일)
    private LocalDate ctrPdBfccEdd; //	해지 전 계약기간(종료일)
    private String ccPp; //	해지목적
    private String ccInt; //	해지기관
    private LocalDate ccPrd; //	해지예정일자
    private String tpRmAtcc; //	해지후 신탁재산의 반환방법
    private Long aqWtnDivOstk; //	해지 전 자기주식 보유현황(배당가능범위 내 취득(주)(보통주식))
    private Double aqWtnDivOstkRt; //	해지 전 자기주식 보유현황(배당가능범위 내 취득(주)(비율(%)))
    private Long aqWtnDivEstk; //	해지 전 자기주식 보유현황(배당가능범위 내 취득(주)(기타주식))
    private Double aqWtnDivEstkRt; //	해지 전 자기주식 보유현황(배당가능범위 내 취득(주)(비율(%)))
    private Long eaqOstk; //	해지 전 자기주식 보유현황(기타취득(주)(보통주식))
    private Double eaqOstkRt; //	해지 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private Long eaqEstk; //	해지 전 자기주식 보유현황(기타취득(주)(기타주식))
    private Double eaqEstkRt; //	해지 전 자기주식 보유현황(기타취득(주)(비율(%)))
    private LocalDate bddd; //	이사회결의일(결정일)
    private Long odAAtT; //	사외이사참석여부(참석(명))
    private Long odAAtB; //	사외이사참석여부(불참(명))
    private String adtAAtn; //	감사(사외이사가 아닌 감사위원)참석여부
}
