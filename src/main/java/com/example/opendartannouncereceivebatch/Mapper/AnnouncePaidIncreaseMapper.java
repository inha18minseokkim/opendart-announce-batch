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
            @Mapping(target = "receptNumber", expression="java(java.lang.Long.parseLong(element.getRcept_no()))"),
            @Mapping(target = "corpClass", source = "corp_cls"),
            @Mapping(target = "corpCode", source = "corp_code"),
            @Mapping(target = "corpName", source = "corp_name"),
            @Mapping(target = "newNormalKindCount", expression="java(java.lang.Long.parseLong(element.getNstk_ostk_cnt()))"),
            @Mapping(target = "newEtcKindCount", expression = "java(java.lang.Long.parseLong(element.getNstk_estk_cnt()))"),
            @Mapping(target = "farValue", expression = "java(java.lang.Long.parseLong(element.getFv_ps()))"),
            @Mapping(target = "capitalStockBeforeIncrease", expression = "java(java.lang.Long.parseLong(element.getBfic_tisstk_ostk()))"),
            @Mapping(target = "capitalEtcStockBeforeIncrease", expression = "java(java.lang.Long.parseLong(element.getBfic_tisstk_estk()))"),
            @Mapping(target = "fundForEquipment", expression = "java(java.lang.Long.parseLong(element.getFdpp_fclt()))"),
            @Mapping(target = "fundForTransfer", expression = "java(java.lang.Long.parseLong(element.getFdpp_bsninh()))"),
            @Mapping(target = "fundForOperation", expression = "java(java.lang.Long.parseLong(element.getFdpp_op()))"),
            @Mapping(target = "fundForRedemption", expression = "java(java.lang.Long.parseLong(element.getFdpp_dtrp()))"),
            @Mapping(target = "fundForSecurityAcquisition", expression = "java(java.lang.Long.parseLong(element.getFdpp_ocsa()))"),
            @Mapping(target = "fundForEtc", expression = "java(java.lang.Long.parseLong(element.getFdpp_etc()))"),
            @Mapping(target = "increaseMethod", source = "ic_mthn"),
            @Mapping(target = "shortSellingStatus", source = "ssl_at"),
            @Mapping(target = "shortSellingBeginDate", expression = "java(java.time.LocalDate.parse(element.getSsl_bgd(),java.time.format.DateTimeFormatter.ofPattern(\"yyyyMMdd\")))"),
            @Mapping(target = "shortSellingEndDate", expression = "java(java.time.LocalDate.parse(element.getSsl_edd(),java.time.format.DateTimeFormatter.ofPattern(\"yyyyMMdd\")))")
    })
    AnnouncePaidIncrease from(AnnouncePaidIncreaseElement element);
}
