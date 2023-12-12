package com.example.opendartannouncereceivebatch.Code;

import com.example.opendartannouncereceivebatch.DTO.ListElement.*;
import com.example.opendartannouncereceivebatch.Entity.*;
import com.example.opendartannouncereceivebatch.Mapper.*;
import com.example.opendartannouncereceivebatch.Writer.*;
import lombok.Getter;

import java.util.function.Predicate;

@Getter
public enum AnnounceKindCode {
    /*유상증자*/
    PAID_INCREASE("https://opendart.fss.or.kr/api/piicDecsn.json",AnnouncePaidIncreaseElement.class,
            AnnouncePaidIncrease.class, AnnouncePaidIncreaseMapper.class, PaidIncreaseWriter.class,
            ((AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("증자")) return false;
                if(!element.getReportNm().contains("유상")) return false;
                return true;
            })),
    /*무상증자*/
    FREE_ISSUE("https://opendart.fss.or.kr/api/fricDecsn.json",AnnounceFreeIssueElement.class,
            AnnounceFreeIssue.class, AnnounceFreeIssueMapper.class, FreeIssueWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("증자")) return false;
                if(!element.getReportNm().contains("무상")) return false;
                return true;
            }),
    /*감자*/
    CAPITAL_REDUCTION("https://opendart.fss.or.kr/api/crDecsn.json", AnnounceCapitalReductionElement.class,
            AnnounceCapitalReduction.class, AnnounceCapitalReductionMapper.class, CapitalReductionWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("감자")) return false;
                return true;
            }),
    /*자기주식처분*/
    STOCK_DISPOSITION("https://opendart.fss.or.kr/api/tsstkDpDecsn.json",StockDispositionElement.class,
            AnnounceStockDisposition.class, AnnounceStockDispositionMapper.class, StockDispositionWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("주식")) return false;
                if(!element.getReportNm().contains("처분")) return false;
                return true;
            }),
    /*자기주식취득*/
    STOCK_ACQUISITION("https://opendart.fss.or.kr/api/tsstkAqDecsn.json",StockAcquisitionElement.class,
            AnnounceStockAcquisition.class, AnnounceStockAcquisitionMapper.class, StockAcquisitionWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("주식")) return false;
                if(!element.getReportNm().contains("취득")) return false;
                return true;
            }),
    /*전환사채발행결정*/
    CONVERTIBLE_BOND("https://opendart.fss.or.kr/api/cvbdIsDecsn.json",ConvertibleBondElement.class,
            AnnounceConvertibleBond.class, AnnounceConvertibleBondMapper.class, ConvertibleBondWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("전환")) return false;
                if(!element.getReportNm().contains("사채")) return false;
                if(!element.getReportNm().contains("발행")) return false;
                return true;
            }),
    /*신주인수권부사채발행결정*/
    BOND_WITH_WARRANT("https://opendart.fss.or.kr/api/bdwtIsDecsn.json",BondWithWarrantElement.class,
            AnnounceBondWithWarrant.class, AnnounceBondWithWarrantMapper.class, BondWithWarrantWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("신주")) return false;
                if(!element.getReportNm().contains("사채")) return false;
                if(!element.getReportNm().contains("발행")) return false;
                return true;
            }),
    /*교환사채권발행결정*/
    EXCHANGEABLE_BOND("https://opendart.fss.or.kr/api/exbdIsDecsn.json",ExchangeableBondElement.class,
            AnnounceExchangeableBond.class, AnnounceExchangeableBondMapper.class, ExchangeableBondWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("신주")) return false;
                if(!element.getReportNm().contains("사채")) return false;
                if(!element.getReportNm().contains("발행")) return false;
                return true;
            }),
    /*자기주식취득신탁계약체결*/
    STOCK_ACQUISITION_TRUST_CONTRACT("https://opendart.fss.or.kr/api/tsstkAqTrctrCnsDecsn.json",StockAcquisitionTrustContractElement.class,
            AnnounceStockAcquisitionTrustContract.class,AnnounceStockAcquisitionTrustContractMapper.class, StockAcquisitionTrustContractWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("자기")) return false;
                if(!element.getReportNm().contains("주식")) return false;
                if(!element.getReportNm().contains("취득")) return false;
                if(!element.getReportNm().contains("신탁")) return false;
                if(!element.getReportNm().contains("체결")) return false;
                return true;
            }
    ),
    /*자기주식취득신탁계약해지*/
    STOCK_ACQUISITION_TRUST_TERMINATION("https://opendart.fss.or.kr/api/tsstkAqTrctrCcDecsn.json",StockAcquisitionTrustCloseElement.class,
            AnnounceStockAcquisitionTrustClose.class,AnnounceStockAcquisitionTrustCloseMapper.class, StockAcquisitionTrustCloseWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("자기")) return false;
                if(!element.getReportNm().contains("주식")) return false;
                if(!element.getReportNm().contains("취득")) return false;
                if(!element.getReportNm().contains("신탁")) return false;
                if(!element.getReportNm().contains("해지")) return false;
                return true;
            }),
    /*소송등의제기*/
    STARTING_SUIT("https://opendart.fss.or.kr/api/lwstLg.json",StartingSuitElement.class,
            AnnounceStartingSuit.class, AnnounceStartingSuitMapper.class, StartingSuitWriter.class,
            (AnnounceDefault element) -> {
                if(!element.getReportNm().contains("주요사항")) return false;
                if(!element.getReportNm().contains("소송")) return false;
                return true;
            });

    /*호출 할 uri 저장*/
    String uri;
    /*response 시 list를 명세한 response객체*/
    Class<? extends EssentialResponseElement> responseClass;
    /*entity 사용 객체*/
    Class<? extends EssentialReport> entityClass;
    /*ResponseElement -> Entity 매핑 인터페이스 클래스 타입*/
    Class<? extends EssentialMapper> mapperInterface;
    /*Repository 접근하는 EssentialWriter클래스*/
    Class<? extends EssentialWriter> essentialWriter;
    /*EssentialApiReceive 시 대상 리포트 거르는 필터*/
    Predicate<AnnounceDefault> filter;

    //Preicate 추가 후에 지울 예정
    AnnounceKindCode(String uri, Class<? extends EssentialResponseElement> responseClass,
                     Class<? extends EssentialReport> entityClass, Class<? extends EssentialMapper> mapperInterface,
                        Class<? extends EssentialWriter> essentialWriter) {
        this.uri = uri;
        this.responseClass = responseClass;
        this.entityClass = entityClass;
        this.mapperInterface = mapperInterface;
        this.essentialWriter = essentialWriter;
    }
    AnnounceKindCode(String uri, Class<? extends EssentialResponseElement> responseClass,
                     Class<? extends EssentialReport> entityClass, Class<? extends EssentialMapper> mapperInterface,
                     Class<? extends EssentialWriter> essentialWriter, Predicate<AnnounceDefault> filter) {
        this.uri = uri;
        this.responseClass = responseClass;
        this.entityClass = entityClass;
        this.mapperInterface = mapperInterface;
        this.essentialWriter = essentialWriter;
        this.filter = filter;
    }
}
