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
    private String corp_code;
    @Column(name="corp_name")
    private String corp_name;
    @Column(name="stock_code")
    private String stock_code;
    @Column(name="modify_date")
    private LocalDate modify_date;
}
