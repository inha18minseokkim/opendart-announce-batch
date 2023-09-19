package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드가 있으면 빌드 시 에러
)
public interface AnnounceDefaultMapper {

    @Mappings({
            @Mapping(source="corp_cls",target="corpClass"),
            @Mapping(source="corp_name",target="corpName"),
            @Mapping(source="corp_code",target="corpCode"),
            @Mapping(source="stock_code",target="stockCode"),
            @Mapping(source="report_nm",target="reportName"),
            @Mapping(target="receptNumber",expression="java(java.lang.Long.parseLong(announceDefaultElement.getRcept_no()))"),
            @Mapping(source="flr_nm",target="submitterName"),
            @Mapping(target="receptDate",expression = "java(java.time.LocalDate.parse(announceDefaultElement.getRcept_dt(), java.time.format.DateTimeFormatter.ofPattern(\"yyyyMMdd\")))"),
            @Mapping(source="rm",target="room"),
    })
    AnnounceDefault from(AnnounceDefaultElement announceDefaultElement);

}
