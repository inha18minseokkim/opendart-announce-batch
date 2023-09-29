package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.DTO.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeParseException;


@Slf4j
public class AnnouncePaidIncreaseMapper implements EssentialMapper {
    //AnnouncePaidIncrease AnnouncePaidIncreaseElement
    @Override
    public EssentialReport from(EssentialResponseElement element){
        if ( element == null ) {
            return null;
        }
        AnnouncePaidIncreaseElement announcePaidIncreaseElement = (AnnouncePaidIncreaseElement) element;
        AnnouncePaidIncrease.AnnouncePaidIncreaseBuilder announcePaidIncrease = AnnouncePaidIncrease.builder();

        announcePaidIncrease.corpClass( announcePaidIncreaseElement.getCorp_cls() );
        announcePaidIncrease.corpCode( announcePaidIncreaseElement.getCorp_code() );
        announcePaidIncrease.corpName( announcePaidIncreaseElement.getCorp_name() );
        announcePaidIncrease.increaseMethod( announcePaidIncreaseElement.getIc_mthn() );
        announcePaidIncrease.shortSellingStatus( announcePaidIncreaseElement.getSsl_at() );
        try {
            announcePaidIncrease.receptNumber(java.lang.Long.parseLong(announcePaidIncreaseElement.getRcept_no()));
        } catch(NumberFormatException e){
            log.info(announcePaidIncreaseElement.getRcept_no());
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.newNormalKindCount(java.lang.Long.parseLong(announcePaidIncreaseElement.getNstk_ostk_cnt()));
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.newEtcKindCount(java.lang.Long.parseLong(announcePaidIncreaseElement.getNstk_estk_cnt()));
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.farValue( java.lang.Long.parseLong(announcePaidIncreaseElement.getFv_ps()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try{
            announcePaidIncrease.capitalStockBeforeIncrease( java.lang.Long.parseLong(announcePaidIncreaseElement.getBfic_tisstk_ostk()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try{
            announcePaidIncrease.capitalEtcStockBeforeIncrease( java.lang.Long.parseLong(announcePaidIncreaseElement.getBfic_tisstk_estk()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.fundForEquipment( java.lang.Long.parseLong(announcePaidIncreaseElement.getFdpp_fclt()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.fundForTransfer( java.lang.Long.parseLong(announcePaidIncreaseElement.getFdpp_bsninh()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.fundForOperation( java.lang.Long.parseLong(announcePaidIncreaseElement.getFdpp_op()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try{
            announcePaidIncrease.fundForRedemption( java.lang.Long.parseLong(announcePaidIncreaseElement.getFdpp_dtrp()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.fundForSecurityAcquisition( java.lang.Long.parseLong(announcePaidIncreaseElement.getFdpp_ocsa()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.fundForEtc( java.lang.Long.parseLong(announcePaidIncreaseElement.getFdpp_etc()) );
        } catch(NumberFormatException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.shortSellingBeginDate( java.time.LocalDate.parse(announcePaidIncreaseElement.getSsl_bgd(),java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")) );
        } catch(DateTimeParseException e){
            announcePaidIncrease.receptNumber(null);
        }
        try {
            announcePaidIncrease.shortSellingEndDate( java.time.LocalDate.parse(announcePaidIncreaseElement.getSsl_edd(),java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")) );
        } catch(DateTimeParseException e){
            announcePaidIncrease.receptNumber(null);
        }

        return announcePaidIncrease.build();
    }

}
