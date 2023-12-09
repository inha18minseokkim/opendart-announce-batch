package com.example.opendartannouncereceivebatch.Tasklet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatTest {
    @Test
    void dateFormatTest() {
        LocalDate curDate = LocalDate.parse("20231207", DateTimeFormatter.ofPattern("yyyyMMdd"));
        Assertions.assertThat(curDate.getYear()).isEqualTo(2023);
        Assertions.assertThat(curDate.getMonthValue()).isEqualTo(12);
        Assertions.assertThat(curDate.getDayOfMonth()).isEqualTo(7);
    }
}
