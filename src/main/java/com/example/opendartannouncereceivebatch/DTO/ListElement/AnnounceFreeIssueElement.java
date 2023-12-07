package com.example.opendartannouncereceivebatch.DTO.ListElement;


import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnounceFreeIssueElement implements EssentialResponseElement {
    private String rceptNo; //접수번호
    private String corpCls; //법인구분
    private String corpCode; //고유번호
    private String corpName; //회사명
    private String nstkOstkCnt; //신주의 종류와 수(보통주식 (주))
    private String nstkEstkCnt; //신주의 종류와 수(기타주식 (주))
    private String fvPs; //1주당 액면가액 (원)
    private String bficTisstkOstk; //증자전 발행주식총수 (주)(보통주식 (주))
    private String bficTisstkEstk; //증자전 발행주식총수 (주)(기타주식 (주))
    private String nstkAsstd; //신주배정기준일
    private String nstkAscntPsOstk; //1주당 신주배정 주식수(보통주식 (주))
    private String nstkAscntPsEstk; //1주당 신주배정 주식수(기타주식 (주))
    private String nstkDividrk; //신주의 배당기산일
    private String nstkDlprd; //신주권교부예정일
    private String nstkLstprd; //신주의 상장 예정일
    private String bddd; //이사회결의일(결정일)
    private String odAAtT; //사외이사 참석여부(참석(명))
    private String odAAtB; //사외이사 참석여부(불참(명))
    private String adtAAtn; //감사(감사위원)참석 여부
}
