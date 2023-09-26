package com.example.opendartannouncereceivebatch.DTO;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnouncePaidIncreaseElement {
    //	접수번호
    private String rcept_no;
    //	법인구분
    private String corp_cls;
    //	고유번호
    private String corp_code;
    //	회사명
    private String corp_name;
    //	신주의 종류와 수(보통주식 (주))
    private String nstk_ostk_cnt;
    //	신주의 종류와 수(기타주식 (주))
    private String nstk_estk_cnt;
    //	1주당 액면가액 (원)
    private String fv_ps;
    //	증자전 발행주식총수 (주)(보통주식 (주))
    private String bfic_tisstk_ostk;
    //	증자전 발행주식총수 (주)(기타주식 (주))
    private String bfic_tisstk_estk;
    //	자금조달의 목적(시설자금 (원))
    private String fdpp_fclt;
    //	자금조달의 목적(영업양수자금 (원))
    private String fdpp_bsninh;
    //	자금조달의 목적(운영자금 (원))
    private String fdpp_op;
    //	자금조달의 목적(채무상환자금 (원))
    private String fdpp_dtrp;
    //	자금조달의 목적(타법인 증권 취득자금 (원))
    private String fdpp_ocsa;
    //	자금조달의 목적(기타자금 (원))
    private String fdpp_etc;
    //	증자방식
    private String ic_mthn;
    //	공매도 해당여부
    private String ssl_at;
    //	공매도 시작일
    private String ssl_bgd;
    //	공매도 종료일
    private String ssl_edd;
}
