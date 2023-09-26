package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface AnnouncePaidIncreaseMapper {
    @Mappings({
            @Mapping(target = "receptNumber", expression="java(java.lang.Long.parseLong(announceDefaultElement.getRcept_no()))"), // 접수번호
            @Mapping(target = "corpClass", source = "corp_cls"), // 법인구분
            @Mapping(target = "corpCode", source = "corp_code"), // 고유번호
            @Mapping(target = "corpName", source = "corp_name"), // 회사명
            @Mapping(target = "newNormalKindCount", expression="java(java.lang.Long.parseLong(element.getNstk_ostk_cnt()))"), // 신주의 종류와 수(보통주식 (주))
            @Mapping(target = "newEtcKindCount", expression = "java(java.lang.Long.parseLong(element.getNstk_estk_cnt()))"), // 신주의 종류와 수(기타주식 (주))
            @Mapping(target = "farValue", expression = "java(java.lang.Long.parseLong(element.getFv_ps()))"), // 1주당 액면가액 (원)
            @Mapping(target = "capitalStockBeforeIncrease", expression = "java(java.lang.Long.parseLong(element.getBfic_tisstk_ostk()))"), // 증자전 발행주식총수 (주)(보통주식 (주))
            @Mapping(target = "capitalEtcStockBeforeIncrease", expression = "java(java.lang.Long.parseLong(element.getBfic_tisstk_estk()))"), // 증자전 발행주식총수 (주)(기타주식 (주))
            @Mapping(target = "fundForEquipment", expression = "java(java.lang.Long.parseLong(element.getFdpp_fclt()))"), // 자금조달의 목적(시설자금 (원))
            @Mapping(target = "fundForTransfer", expression = "java(java.lang.Long.parseLong(element.getFdpp_bsninh()))"), // 자금조달의 목적(영업양수자금 (원))
            @Mapping(target = "fundForOperation", expression = "java(java.lang.Long.parseLong(element.getFdpp_op()))"), // 자금조달의 목적(운영자금 (원))
            @Mapping(target = "fundForRedemption", expression = "java(java.lang.Long.parseLong(element.getFdpp_dtrp()))"), // 자금조달의 목적(채무상환자금 (원))
            @Mapping(target = "fundForSecurityAcquisition", expression = "java(java.lang.Long.parseLong(element.getFdpp_ocsa()))"), // 자금조달의 목적(타법인 증권 취득자금 (원))
            @Mapping(target = "fundForEtc", expression = "java(java.lang.Long.parseLong(element.getFdpp_etc()))"), // 자금조달의 목적(기타자금 (원))
            @Mapping(target = "increaseMethod", source = "ic_mthn"), // 증자방식
            @Mapping(target = "shortSellingStatus", source = "ssl_at"), // 공매도 해당여부
            @Mapping(target = "shortSellingBeginDate", expression = "java(java.time.LocalDate.parse(element.getSsl_bgd(), " +
                    "java.time.format.DateTimeFormatter.ofPattern(\\\"yyyyMMdd\\\")))\""), // 공매도 시작일
            @Mapping(target = "shortSellingEndDate", expression = "java(java.time.LocalDate.parse(element.getSsl_edd(), " +
                    "java.time.format.DateTimeFormatter.ofPattern(\\\"yyyyMMdd\\\")))\"") // 공매도 종료일
    })
    AnnouncePaidIncrease from(AnnouncePaidIncreaseElement element);
}
