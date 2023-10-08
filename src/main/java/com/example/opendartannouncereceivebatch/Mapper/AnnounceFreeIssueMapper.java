package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.AnnounceFreeIssueElement;
import com.example.opendartannouncereceivebatch.DTO.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnounceFreeIssue;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AnnounceFreeIssueMapper implements EssentialMapper {
    private Long parseLong(String target){
        try{
            return Long.parseLong(target);
        }catch(NumberFormatException e){
            return null;
        }
    }
    private LocalDate parseLocalDate(String target){
        try{
            return LocalDate.parse(target, DateTimeFormatter.ofPattern("yyyyMMdd"));
        }catch(DateTimeParseException e){
            return null;
        }
    }
    @Override
    public EssentialReport from(EssentialResponseElement element) {
        AnnounceFreeIssueElement fromElement = (AnnounceFreeIssueElement) element;
        AnnounceFreeIssue target = AnnounceFreeIssue.builder()
                .receptNumber(Long.parseLong(fromElement.getRcept_no()))
                .corpClass(fromElement.getCorp_cls())
                .corpCode(fromElement.getCorp_code())
                .corpName(fromElement.getCorp_name())
                .newNormalKindCount(parseLong(fromElement.getNstk_ostk_cnt()))
                .newEtcKindCount(parseLong(fromElement.getNstk_estk_cnt()))
                .farValue(parseLong(fromElement.getFv_ps()))
                .capitalStockBeforeIncrease(parseLong(fromElement.getBfic_tisstk_ostk()))
                .capitalEtcStockBeforeIncrease(parseLong(fromElement.getBfic_tisstk_estk()))
                .newStockAllotBaseDate(parseLocalDate(fromElement.getNstk_asstd()))
                .newAllotNumberPerNormalStock(parseLong(fromElement.getNstk_ascnt_ps_estk()))
                .newStockReckoningDate(parseLocalDate(fromElement.getNstk_dividrk()))
                .newStockIssueDate(parseLocalDate(fromElement.getNstk_dlprd()))
                .newStockListDate(parseLocalDate(fromElement.getNstk_lstprd()))
                .boardOfDirectionDate(parseLocalDate(fromElement.getBddd()))
                .outsideDirectorAttendance(parseLong(fromElement.getOd_a_at_t()))
                .outsideDirectorNonAttendance(parseLong(fromElement.getOd_a_at_b()))
                .InspectionAttendance(fromElement.getAdt_a_atn())
                .build();

        return target;
    }
}
