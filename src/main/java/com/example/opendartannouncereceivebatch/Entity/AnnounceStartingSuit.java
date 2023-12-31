package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class AnnounceStartingSuit implements EssentialReport{
    @Id
    private String rceptNo; //	접수번호
    private String corpCls; //	법인구분
    private String corpCode; //	고유번호
    private String corpName; //	회사명
    @Column(length=1000)
    private String icnm; //	사건의 명칭
    private String acAp; //	원고ㆍ신청인
    @Column(length=2000)
    private String rqCn; //	청구내용
    @Column(length=1000)
    private String cpct; //	관할법원
    @Column(length=1000)
    private String ftCtp; //	향후대책
    private LocalDate lgd; //	제기일자
    private LocalDate cfd; //	확인일자
}
