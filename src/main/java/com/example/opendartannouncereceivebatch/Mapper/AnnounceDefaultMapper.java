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
            @Mapping(target="rcept_no",expression="java(java.lang.Long.parseLong(announceDefaultElement.getRcept_no()))"),
            @Mapping(target="rcept_dt",expression = "java(java.time.LocalDate.parse(announceDefaultElement.getRcept_dt(), java.time.format.DateTimeFormatter.ofPattern(\"yyyyMMdd\")))")
    })
    AnnounceDefault from(AnnounceDefaultElement announceDefaultElement);

}
