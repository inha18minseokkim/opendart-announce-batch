package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity(name="AnnouncePaidIncrease")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class AnnouncePaidIncrease implements EssentialReport {
    @Id
    private Long rceptNo;//	접수번호
    private String corpCls;//	법인구분
    private String corpCode;//	고유번호
    private String corpName;//	회사명
    private Long nstkOstkCnt;//	신주의 종류와 수(보통주식 (주))
    private Long nstkEstkCnt;//	신주의 종류와 수(기타주식 (주))
    private Long fvPs;//	1주당 액면가액 (원)
    private Long bficTisstkOstk;//	증자전 발행주식총수 (주)(보통주식 (주))
    private Long bficTisstkEstk;//	증자전 발행주식총수 (주)(기타주식 (주))
    private Long fdppFclt;//	자금조달의 목적(시설자금 (원))
    private Long fdppBsninh;//	자금조달의 목적(영업양수자금 (원))
    private Long fdppOp;//	자금조달의 목적(운영자금 (원))
    private Long fdppDtrp;//	자금조달의 목적(채무상환자금 (원))
    private Long fdppOcsa;//	자금조달의 목적(타법인 증권 취득자금 (원))
    private Long fdppEtc;//	자금조달의 목적(기타자금 (원))
    @Column(length=1000)
    private String icMthn;//	증자방식
    private String sslAt;//	공매도 해당여부
    private LocalDate sslBgd;//	공매도 시작일
    private LocalDate sslEdd;//	공매도 종료일
}
