package com.example.opendartannouncereceivebatch.Code;

import com.example.opendartannouncereceivebatch.DTO.ListElement.*;
import com.example.opendartannouncereceivebatch.Entity.*;
import com.example.opendartannouncereceivebatch.Mapper.AnnounceCapitalReductionMapper;
import com.example.opendartannouncereceivebatch.Mapper.AnnounceFreeIssueMapper;
import com.example.opendartannouncereceivebatch.Mapper.AnnouncePaidIncreaseMapper;
import com.example.opendartannouncereceivebatch.Mapper.AnnounceStockDispositionMapper;
import com.example.opendartannouncereceivebatch.Writer.*;
import lombok.Getter;

import java.util.function.Predicate;

@Getter
public enum AnnounceKindCode {
    /*유상증자*/
    PAID_INCREASE("https://opendart.fss.or.kr/api/piicDecsn.json",AnnouncePaidIncreaseElement.class,
            AnnouncePaidIncrease.class, AnnouncePaidIncreaseMapper.class, PaidIncreaseWriter.class
    ,((AnnounceDefault element) -> {
        if(!element.getReportNm().contains("주요사항")) return false;
        if(!element.getReportNm().contains("증자")) return false;
        if(!element.getReportNm().contains("유상")) return false;
        return true;
    })),
    /*무상증자*/
    FREE_ISSUE("https://opendart.fss.or.kr/api/fricDecsn.json",AnnounceFreeIssueElement.class,
            AnnounceFreeIssue.class, AnnounceFreeIssueMapper.class, FreeIssueWriter.class
    ,(AnnounceDefault element) -> {
        if(!element.getReportNm().contains("주요사항")) return false;
        if(!element.getReportNm().contains("증자")) return false;
        if(!element.getReportNm().contains("무상")) return false;
        return true;
    }),
    /*감자*/
    CAPITAL_REDUCTION("https://opendart.fss.or.kr/api/crDecsn.json", AnnounceCapitalReductionElement.class,
            AnnounceCapitalReduction.class, AnnounceCapitalReductionMapper.class, CapitalReductionWriter.class
    ,(AnnounceDefault element) -> {
        if(!element.getReportNm().contains("주요사항")) return false;
        if(!element.getReportNm().contains("감자")) return false;
        return true;
    }),
    /*자기주식처분*/
    STOCK_DISPOSITION("https://opendart.fss.or.kr/api/tsstkDpDecsn.json",StockDispositionElement.class,
                      AnnounceStockDisposition.class, AnnounceStockDispositionMapper.class, StockDispositionWriter.class
    ,(AnnounceDefault element) -> {
        if(!element.getReportNm().contains("주요사항")) return false;
        if(!element.getReportNm().contains("주식")) return false;
        if(!element.getReportNm().contains("처분")) return false;
        return true;
    });

    /*호출 할 uri 저장*/
    String uri;
    /*response 시 list를 명세한 response객체*/
    Class<? extends EssentialResponseElement> responseClass;
    /*entity 사용 객체*/
    Class<? extends EssentialReport> entityClass;
    /*ResponseElement -> Entity 매핑 인터페이스 클래스 타입*/
    Class<?> mapperInterface;
    /*Repository 접근하는 EssentialWriter클래스*/
    Class<? extends EssentialWriter> essentialWriter;
    /*EssentialApiReceive 시 대상 리포트 거르는 필터*/
    Predicate<AnnounceDefault> filter;

    //Preicate 추가 후에 지울 예정
    AnnounceKindCode(String uri, Class<? extends EssentialResponseElement> responseClass,
                     Class<? extends EssentialReport> entityClass, Class<?> mapperInterface,
                        Class<? extends EssentialWriter> essentialWriter) {
        this.uri = uri;
        this.responseClass = responseClass;
        this.entityClass = entityClass;
        this.mapperInterface = mapperInterface;
        this.essentialWriter = essentialWriter;
    }
    AnnounceKindCode(String uri, Class<? extends EssentialResponseElement> responseClass,
                     Class<? extends EssentialReport> entityClass, Class<?> mapperInterface,
                     Class<? extends EssentialWriter> essentialWriter, Predicate<AnnounceDefault> filter) {
        this.uri = uri;
        this.responseClass = responseClass;
        this.entityClass = entityClass;
        this.mapperInterface = mapperInterface;
        this.essentialWriter = essentialWriter;
        this.filter = filter;
    }
}
