package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity(name="AnnouncePaidIncrease")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AnnouncePaidIncrease {
    @Id
    private Long receptNumber;  // rcept_no : 접수번호
    private String corpClass;  // corp_cls : 법인구분
    private String corpCode;  // corp_code : 고유번호
    private String corpName;  // corp_name : 회사명
    private Long newNormalKindCount;  // nstk_ostk_cnt : 신주의 종류와 수(보통주식 (주))
    private Long newEtcKindCount;  // nstk_estk_cnt : 신주의 종류와 수(기타주식 (주))
    private Long farValue;  // fv_ps : 1주당 액면가액 (원)
    private Long capitalStockBeforeIncrease;  // bfic_tisstk_ostk : 증자전 발행주식총수 (주)(보통주식 (주))
    private Long capitalEtcStockBeforeIncrease;  // bfic_tisstk_estk : 증자전 발행주식총수 (주)(기타주식 (주))
    private Long fundForEquipment;  // fdpp_fclt : 자금조달의 목적(시설자금 (원))
    private Long fundForTransfer;  // fdpp_bsninh : 자금조달의 목적(영업양수자금 (원))
    private Long fundForOperation;  // fdpp_op : 자금조달의 목적(운영자금 (원))
    private Long fundForRedemption;  // fdpp_dtrp : 자금조달의 목적(채무상환자금 (원))
    private Long fundForSecurityAcquisition;  // fdpp_ocsa : 자금조달의 목적(타법인 증권 취득자금 (원))
    private Long fundForEtc;  // fdpp_etc : 자금조달의 목적(기타자금 (원))
    private String increaseMethod;  // ic_mthn : 증자방식
    private String shortSellingStatus;  // ssl_at : 공매도 해당여부
    private LocalDate shortSellingBeginDate;  // ssl_bgd : 공매도 시작일
    private LocalDate shortSellingEndDate;  // ssl_edd : 공매도 종료일
}
