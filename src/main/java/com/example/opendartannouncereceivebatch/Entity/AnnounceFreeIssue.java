package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "AnnounceFreeIssue")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AnnounceFreeIssue implements EssentialReport {
    @Id
    private Long receptNumber; //접수번호
    private String corpClass; //법인구분
    private String corpCode; //고유번호
    private String corpName; //회사명
    private Long newNormalKindCount; //신주의 종류와 수(보통주식 (주))
    private Long newEtcKindCount; //신주의 종류와 수(기타주식 (주))
    private Long farValue; //1주당 액면가액 (원)
    private Long capitalStockBeforeIncrease; //증자전 발행주식총수 (주)(보통주식 (주))
    private Long capitalEtcStockBeforeIncrease; //증자전 발행주식총수 (주)(기타주식 (주))
    private LocalDate newStockAllotBaseDate; //신주배정기준일
    private Long newAllotNumberPerNormalStock; //1주당 신주배정 주식수(보통주식 (주))
    private Long newAllotNumberPerEtcStock; //1주당 신주배정 주식수(기타주식 (주))
    private LocalDate newStockReckoningDate; //신주의 배당기산일
    private LocalDate newStockIssueDate; //신주권교부예정일
    private LocalDate newStockListDate; //신주의 상장 예정일
    private LocalDate boardOfDirectionDate; //이사회결의일(결정일)
    private Long outsideDirectorAttendance; //사외이사 참석여부(참석(명))
    private Long outsideDirectorNonAttendance; //사외이사 참석여부(불참(명))
    private String InspectionAttendance; //감사(감사위원)참석 여부
}
