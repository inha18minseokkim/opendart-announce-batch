package com.example.opendartannouncereceivebatch.DTO.ListElement;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnouncePaidIncreaseElement implements EssentialResponseElement {
    private String rceptNo;//	접수번호
    private String corpCls;//	법인구분
    private String corpCode;//	고유번호
    private String corpName;//	회사명
    private String nstkOstkCnt;//	신주의 종류와 수(보통주식 (주))
    private String nstkEstkCnt;//	신주의 종류와 수(기타주식 (주))
    private String fvPs;//	1주당 액면가액 (원)
    private String bficTisstkOstk;//	증자전 발행주식총수 (주)(보통주식 (주))
    private String bficTisstkEstk;//	증자전 발행주식총수 (주)(기타주식 (주))
    private String fdppFclt;//	자금조달의 목적(시설자금 (원))
    private String fdppBsninh;//	자금조달의 목적(영업양수자금 (원))
    private String fdppOp;//	자금조달의 목적(운영자금 (원))
    private String fdppDtrp;//	자금조달의 목적(채무상환자금 (원))
    private String fdppOcsa;//	자금조달의 목적(타법인 증권 취득자금 (원))
    private String fdppEtc;//	자금조달의 목적(기타자금 (원))
    private String icMthn;//	증자방식
    private String sslAt;//	공매도 해당여부
    private String sslBgd;//	공매도 시작일
    private String sslEdd;//	공매도 종료일
}
