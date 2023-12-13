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
public class AnnounceBondWithWarrant implements EssentialReport{
    @Id
    private String rceptNo; //	접수번호
    private String corpCls; //	법인구분
    private String corpCode; //	고유번호
    private String corpName; //	회사명
    private String bdTm; //	사채의 종류(회차)
    private String bdKnd; //	사채의 종류(종류)
    private Long bdFta; //	사채의 권면(전자등록)총액 (원)
    private Long atcscRmislmt; //	정관상 잔여 발행한도 (원)
    private Long ovisFta; //	해외발행(권면(전자등록)총액)
    private String ovisFtaCrn; //	해외발행(권면(전자등록)총액(통화단위))
    private String ovisSter; //	해외발행(기준환율등)
    private String ovisIsar; //	해외발행(발행지역)
    private String ovisMktnm; //	해외발행(해외상장시 시장의 명칭)
    private Long fdppFclt; //	자금조달의 목적(시설자금 (원))
    private Long fdppBsninh; //	자금조달의 목적(영업양수자금 (원))
    private Long fdppOp; //	자금조달의 목적(운영자금 (원))
    private Long fdppDtrp; //	자금조달의 목적(채무상환자금 (원))
    private Long fdppOcsa; //	자금조달의 목적(타법인 증권 취득자금 (원))
    private Long fdppEtc; //	자금조달의 목적(기타자금 (원))
    private Double bdIntrEx; //	사채의 이율(표면이자율 (%))
    private Double bdIntrSf; //	사채의 이율(만기이자율 (%))
    private LocalDate bdMtd; //	사채만기일
    private String bdisMthn; //	사채발행방법
    private Double exRt; //	신주인수권에 관한 사항(행사비율 (%))
    private Long exPrc; //	신주인수권에 관한 사항(행사가액 (원/주))
    @Column(length=1000)
    private String exPrcDmth; //	신주인수권에 관한 사항(행사가액 결정방법)
    @Column(length=1000)
    private String bdwtDivAtn; //	신주인수권에 관한 사항(사채와 인수권의 분리여부)
    @Column(length=1000)
    private String nstkPymMth; //	신주인수권에 관한 사항(신주대금 납입방법)
    private String nstkIsstkKnd; //	신주인수권에 관한 사항(신주인수권 행사에 따라 발행할 주식(종류))
    private Long nstkIsstkCnt; //	신주인수권에 관한 사항(신주인수권 행사에 따라 발행할 주식(주식수))
    private Double nstkIsstkTisstkVs; //	신주인수권에 관한 사항(신주인수권 행사에 따라 발행할 주식(주식총수 대비 비율(%)))
    private LocalDate expdBgd; //	신주인수권에 관한 사항(권리행사기간(시작일))
    private LocalDate expdEdd; //	신주인수권에 관한 사항(권리행사기간(종료일))
    private Long actMktprcflCvprcLwtrsprc; //	신주인수권에 관한 사항(시가하락에 따른 행사가액 조정(최저 조정가액 (원)))
    @Column(length=1000)
    private String actMktprcflCvprcLwtrsprcBs; //	신주인수권에 관한 사항(시가하락에 따른 행사가액 조정(최저 조정가액 근거))
    private Long rmislmtLt70p; //	신주인수권에 관한 사항(시가하락에 따른 행사가액 조정(발행당시 행사가액의 70% 미만으로 조정가능한 잔여 발행한도 (원)))
    private String abmg; //	합병 관련 사항
    private LocalDate sbd; //	청약일
    private LocalDate pymd; //	납입일
    private String rpmcmp; //	대표주관회사
    private String grint; //	보증기관
    private LocalDate bddd; //	이사회결의일(결정일)
    private Long odAAtT; //	사외이사 참석여부(참석 (명))
    private Long odAAtB; //	사외이사 참석여부(불참 (명))
    private String adtAAtn; //	감사(감사위원) 참석여부
    private String rsSmAtn; //	증권신고서 제출대상 여부
    @Column(length=1000)
    private String exSmR; //	제출을 면제받은 경우 그 사유
    private String ovisLtdtl; //	당해 사채의 해외발행과 연계된 대차거래 내역
    private String ftcSttAtn; //	공정거래위원회 신고대상 여부
}
