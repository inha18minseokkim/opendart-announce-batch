package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity(name="corp_code")
@Getter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CorpInfo {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="corp_code")
    private String corpCode;
    @Column(name="corp_name")
    private String corpName;
    @Column(name="stock_code")
    private String stockCode;
    @Column(name="modify_date")
    private LocalDate modifyDate;
}
