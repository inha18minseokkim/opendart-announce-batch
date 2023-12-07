package com.example.opendartannouncereceivebatch.DTO.ListElement;


import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnounceCapitalReductionElement implements EssentialResponseElement {

    private String rceptNo;//접수번호
    private String corpCls;//법인구분
    private String corpCode;//고유번호
    private String corpName;//회사명
    private String crstkOstkCnt;//감자주식의 종류와 수(보통주식 (주))
    private String crstkEstkCnt;//감자주식의 종류와 수(기타주식 (주))
    private String fvPs;//1주당 액면가액 (원)
    private String bfcrCpt;//감자전후 자본금(감자전 (원))
    private String atcrCpt;//감자전후 자본금(감자후 (원))
    private String bfcrTisstkOstk;//감자전후 발행주식수(보통주식 (주)(감자전 (원)))
    private String atcrTisstkOstk;//감자전후 발행주식수(보통주식 (주)(감자후 (원)))
    private String bfcrTisstkEstk;//감자전후 발행주식수(기타주식 (주)(감자전 (원)))
    private String atcrTisstkEstk;//감자전후 발행주식수(기타주식 (주)(감자후 (원)))
    private String crRtOstk;//감자비율(보통주식 (%))
    private String crRtEstk;//감자비율(기타주식 (%))
    private String crStd;//감자기준일
    private String crMth;//감자방법
    private String crRs;//감자사유
    private String crscGmtsckPrd;//감자일정(주주총회 예정일)
    private String crscTrnmsppd;//감자일정(명의개서정지기간)
    private String crscOsprpd;//감자일정(구주권 제출기간)
    private String crscTrspprpd;//감자일정(매매거래 정지예정기간)
    private String crscOsprpdBgd;//감자일정(구주권 제출기간(시작일))
    private String crscOsprpdEdd;//감자일정(구주권 제출기간(종료일))
    private String crscTrspprpdBgd;//감자일정(매매거래 정지예정기간(시작일))
    private String crscTrspprpdEdd;//감자일정(매매거래 정지예정기간(종료일))
    private String crscNstkdlprd;//감자일정(신주권교부예정일)
    private String crscNstklstprd;//감자일정(신주상장예정일)
    private String cdobprpdBgd;//채권자 이의제출기간(시작일)
    private String cdobprpdEdd;//채권자 이의제출기간(종료일)
    private String osprNstkdlPl;//구주권제출 및 신주권교부장소
    private String bddd;//이사회결의일(결정일)
    private String odAAtT;//사외이사 참석여부(참석(명))
    private String odAAtB;//사외이사 참석여부(불참(명))
    private String adtAAtn;//감사(감사위원) 참석여부
    private String ftcSttAtn;//공정거래위원회 신고대상 여부
}
