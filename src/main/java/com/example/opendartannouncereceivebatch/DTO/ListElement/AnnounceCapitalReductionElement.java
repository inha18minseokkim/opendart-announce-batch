package com.example.opendartannouncereceivebatch.DTO.ListElement;


import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnounceCapitalReductionElement implements EssentialResponseElement {

    private String rcept_no;//접수번호
    private String corp_cls;//법인구분
    private String corp_code;//고유번호
    private String corp_name;//회사명
    private String crstk_ostk_cnt;//감자주식의 종류와 수(보통주식 (주))
    private String crstk_estk_cnt;//감자주식의 종류와 수(기타주식 (주))
    private String fv_ps;//1주당 액면가액 (원)
    private String bfcr_cpt;//감자전후 자본금(감자전 (원))
    private String atcr_cpt;//감자전후 자본금(감자후 (원))
    private String bfcr_tisstk_ostk;//감자전후 발행주식수(보통주식 (주)(감자전 (원)))
    private String atcr_tisstk_ostk;//감자전후 발행주식수(보통주식 (주)(감자후 (원)))
    private String bfcr_tisstk_estk;//감자전후 발행주식수(기타주식 (주)(감자전 (원)))
    private String atcr_tisstk_estk;//감자전후 발행주식수(기타주식 (주)(감자후 (원)))
    private String cr_rt_ostk;//감자비율(보통주식 (%))
    private String cr_rt_estk;//감자비율(기타주식 (%))
    private String cr_std;//감자기준일
    private String cr_mth;//감자방법
    private String cr_rs;//감자사유
    private String crsc_gmtsck_prd;//감자일정(주주총회 예정일)
    private String crsc_trnmsppd;//감자일정(명의개서정지기간)
    private String crsc_osprpd;//감자일정(구주권 제출기간)
    private String crsc_trspprpd;//감자일정(매매거래 정지예정기간)
    private String crsc_osprpd_bgd;//감자일정(구주권 제출기간(시작일))
    private String crsc_osprpd_edd;//감자일정(구주권 제출기간(종료일))
    private String crsc_trspprpd_bgd;//감자일정(매매거래 정지예정기간(시작일))
    private String crsc_trspprpd_edd;//감자일정(매매거래 정지예정기간(종료일))
    private String crsc_nstkdlprd;//감자일정(신주권교부예정일)
    private String crsc_nstklstprd;//감자일정(신주상장예정일)
    private String cdobprpd_bgd;//채권자 이의제출기간(시작일)
    private String cdobprpd_edd;//채권자 이의제출기간(종료일)
    private String ospr_nstkdl_pl;//구주권제출 및 신주권교부장소
    private String bddd;//이사회결의일(결정일)
    private String od_a_at_t;//사외이사 참석여부(참석(명))
    private String od_a_at_b;//사외이사 참석여부(불참(명))
    private String adt_a_atn;//감사(감사위원) 참석여부
    private String ftc_stt_atn;//공정거래위원회 신고대상 여부
}
