package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "AnnounceFreeIssue")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AnnounceFreeIssue implements EssentialReport {
    @Id
    private Long rceptNo; //접수번호
    private String corpCls; //법인구분
    private String corpCode; //고유번호
    private String corpName; //회사명
    private Long nstkOstkCnt; //신주의 종류와 수(보통주식 (주))
    private Long nstkEstkCnt; //신주의 종류와 수(기타주식 (주))
    private Long fvPs; //1주당 액면가액 (원)
    private Long bficTisstkOstk; //증자전 발행주식총수 (주)(보통주식 (주))
    private Long bficTisstkEstk; //증자전 발행주식총수 (주)(기타주식 (주))
    private LocalDate nstkAsstd; //신주배정기준일
    private Long nstkAscntPsOstk; //1주당 신주배정 주식수(보통주식 (주))
    private Long nstkAscntPsEstk; //1주당 신주배정 주식수(기타주식 (주))
    private LocalDate nstkDividrk; //신주의 배당기산일
    private LocalDate nstkDlprd; //신주권교부예정일
    private LocalDate nstkLstprd; //신주의 상장 예정일
    private LocalDate bddd; //이사회결의일(결정일)
    private Long odAAtT; //사외이사 참석여부(참석(명))
    private Long odAAtB; //사외이사 참석여부(불참(명))
    private String adtAAtn; //감사(감사위원)참석 여부
}
