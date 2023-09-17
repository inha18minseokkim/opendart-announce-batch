package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name="TB_CORP_CODE")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorpInfo {
    @Id
    @Column(name="IDX")
    private Long id;
    @Column(name="corp_code")
    private String corpCode;
    @Column(name="corp_name")
    private String corpName;
    @Column(name="stock_code")
    private String stockCode;
    @Column(name="modify_date")
    private LocalDate modify_date;
}
