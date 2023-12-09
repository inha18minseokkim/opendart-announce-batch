package com.example.opendartannouncereceivebatch.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnounceDefaultPageInfo {
    @Id
    private LocalDate rceptDt;
    private Integer currentCount;
}
