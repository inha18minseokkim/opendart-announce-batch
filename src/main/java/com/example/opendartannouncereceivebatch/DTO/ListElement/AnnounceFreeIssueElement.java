package com.example.opendartannouncereceivebatch.DTO.ListElement;


import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnounceFreeIssueElement implements EssentialResponseElement {
    private String rcept_no; //접수번호
    private String corp_cls; //법인구분
    private String corp_code; //고유번호
    private String corp_name; //회사명
    private String nstk_ostk_cnt; //신주의 종류와 수(보통주식 (주))
    private String nstk_estk_cnt; //신주의 종류와 수(기타주식 (주))
    private String fv_ps; //1주당 액면가액 (원)
    private String bfic_tisstk_ostk; //증자전 발행주식총수 (주)(보통주식 (주))
    private String bfic_tisstk_estk; //증자전 발행주식총수 (주)(기타주식 (주))
    private String nstk_asstd; //신주배정기준일
    private String nstk_ascnt_ps_ostk; //1주당 신주배정 주식수(보통주식 (주))
    private String nstk_ascnt_ps_estk; //1주당 신주배정 주식수(기타주식 (주))
    private String nstk_dividrk; //신주의 배당기산일
    private String nstk_dlprd; //신주권교부예정일
    private String nstk_lstprd; //신주의 상장 예정일
    private String bddd; //이사회결의일(결정일)
    private String od_a_at_t; //사외이사 참석여부(참석(명))
    private String od_a_at_b; //사외이사 참석여부(불참(명))
    private String adt_a_atn; //감사(감사위원)참석 여부
}
