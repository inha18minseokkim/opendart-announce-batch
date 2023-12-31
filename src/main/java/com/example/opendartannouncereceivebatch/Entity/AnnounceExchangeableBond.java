package com.example.opendartannouncereceivebatch.Entity;

import com.example.opendartannouncereceivebatch.Writer.EssentialWriter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class AnnounceExchangeableBond implements EssentialReport {
    @Id
    private String rceptNo;	//접수번호
    private String corpCls;	//법인구분
    private String corpCode;	//고유번호
    private String corpName;	//회사명
    private String bdTm;	//사채의 종류(회차)
    private String bdKnd;	//사채의 종류(종류)
    private Long bdFta;	//사채의 권면(전자등록)총액 (원)
    private Long ovisFta;	//해외발행(권면(전자등록)총액)
    private String ovisFtaCrn;	//해외발행(권면(전자등록)총액(통화단위))
    private String ovisSter;	//해외발행(기준환율등)
    private String ovisIsar;	//해외발행(발행지역)
    private String ovisMktnm;	//해외발행(해외상장시 시장의 명칭)
    private Long fdppFclt;	//자금조달의 목적(시설자금 (원))
    private Long fdppBsninh;	//자금조달의 목적(영업양수자금 (원))
    private Long fdppOp;	//자금조달의 목적(운영자금 (원))
    private Long fdppDtrp;	//자금조달의 목적(채무상환자금 (원))
    private Long fdppOcsa;	//자금조달의 목적(타법인 증권 취득자금 (원))
    private Long fdppEtc;	//자금조달의 목적(기타자금 (원))
    private Double bdIntrEx;	//사채의 이율(표면이자율 (%))
    private Double bdIntrSf;	//사채의 이율(만기이자율 (%))
    private LocalDate bdMtd;	//사채만기일
    private String bdisMthn;	//사채발행방법
    private Double exRt;	//교환에 관한 사항(교환비율 (%))
    private Long exPrc;	//교환에 관한 사항(교환가액 (원/주))
    private String exPrcDmth;	//교환에 관한 사항(교환가액 결정방법)
    private String extg;	//교환에 관한 사항(교환대상(종류))
    private Long extgStkcnt;	//교환에 관한 사항(교환대상(주식수))
    private Double extgTisstkVs;	//교환에 관한 사항(교환대상(주식총수 대비 비율(%)))
    private LocalDate exrqpdBgd;	//교환에 관한 사항(교환청구기간(시작일))
    private LocalDate exrqpdEdd;	//교환에 관한 사항(교환청구기간(종료일))
    private LocalDate sbd;	//청약일
    private LocalDate pymd;	//납입일
    private String rpmcmp;	//대표주관회사
    private String grint;	//보증기관
    private LocalDate bddd;	//이사회결의일(결정일)
    private Long odAAtT;	//사외이사 참석여부(참석 (명))
    private Long odAAtB;	//사외이사 참석여부(불참 (명))
    private String adtAAtn;	//감사(감사위원) 참석여부
    private String rsSmAtn;	//증권신고서 제출대상 여부
    private String exSmR;	//제출을 면제받은 경우 그 사유
    private String ovisLtdtl;	//당해 사채의 해외발행과 연계된 대차거래 내역
    private String ftcSttAtn;	//공정거래위원회 신고대상 여부
}
