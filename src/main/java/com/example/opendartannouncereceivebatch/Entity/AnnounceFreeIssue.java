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
    private Long rcept_no; //접수번호
    private String corp_cls; //법인구분
    private String corp_code; //고유번호
    private String corp_name; //회사명
    private Long nstk_ostk_cnt; //신주의 종류와 수(보통주식 (주))
    private Long nstk_estk_cnt; //신주의 종류와 수(기타주식 (주))
    private Long fv_ps; //1주당 액면가액 (원)
    private Long bfic_tisstk_ostk; //증자전 발행주식총수 (주)(보통주식 (주))
    private Long bfic_tisstk_estk; //증자전 발행주식총수 (주)(기타주식 (주))
    private LocalDate nstk_asstd; //신주배정기준일
    private Long nstk_ascnt_ps_ostk; //1주당 신주배정 주식수(보통주식 (주))
    private Long nstk_ascnt_ps_estk; //1주당 신주배정 주식수(기타주식 (주))
    private LocalDate nstk_dividrk; //신주의 배당기산일
    private LocalDate nstk_dlprd; //신주권교부예정일
    private LocalDate nstk_lstprd; //신주의 상장 예정일
    private LocalDate bddd; //이사회결의일(결정일)
    private Long od_a_at_t; //사외이사 참석여부(참석(명))
    private Long od_a_at_b; //사외이사 참석여부(불참(명))
    private String adt_a_atn; //감사(감사위원)참석 여부
}
