package com.example.opendartannouncereceivebatch.CommonConfiguration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomSnakeCaseStrategyTest {
    CustomSnakeCaseStrategy strategy = new CustomSnakeCaseStrategy();
    @Test
    void spellCheck() {
        Assertions.assertThat(strategy.convertToSnakeCase("rceptNo")).isEqualTo("rcept_no");
        Assertions.assertThat(strategy.convertToSnakeCase("corpCls")).isEqualTo("corp_cls");
        Assertions.assertThat(strategy.convertToSnakeCase("corpCode")).isEqualTo("corp_code");
        Assertions.assertThat(strategy.convertToSnakeCase("corpName")).isEqualTo("corp_name");
        Assertions.assertThat(strategy.convertToSnakeCase("nstkOstkCnt")).isEqualTo("nstk_ostk_cnt");
        Assertions.assertThat(strategy.convertToSnakeCase("nstkEstkCnt")).isEqualTo("nstk_estk_cnt");
        Assertions.assertThat(strategy.convertToSnakeCase("fvPs")).isEqualTo("fv_ps");
        Assertions.assertThat(strategy.convertToSnakeCase("bficTisstkOstk")).isEqualTo("bfic_tisstk_ostk");
        Assertions.assertThat(strategy.convertToSnakeCase("bficTisstkEstk")).isEqualTo("bfic_tisstk_estk");
        Assertions.assertThat(strategy.convertToSnakeCase("nstkAsstd")).isEqualTo("nstk_asstd");
        Assertions.assertThat(strategy.convertToSnakeCase("nstkAscntPsOstk")).isEqualTo("nstk_ascnt_ps_ostk");
        Assertions.assertThat(strategy.convertToSnakeCase("nstkAscntPsEstk")).isEqualTo("nstk_ascnt_ps_estk");
        Assertions.assertThat(strategy.convertToSnakeCase("nstkDividrk")).isEqualTo("nstk_dividrk");
        Assertions.assertThat(strategy.convertToSnakeCase("nstkDlprd")).isEqualTo("nstk_dlprd");
        Assertions.assertThat(strategy.convertToSnakeCase("nstkLstprd")).isEqualTo("nstk_lstprd");
        Assertions.assertThat(strategy.convertToSnakeCase("bddd")).isEqualTo("bddd");
        Assertions.assertThat(strategy.convertToSnakeCase("odAAtT")).isEqualTo("od_a_at_t");
        Assertions.assertThat(strategy.convertToSnakeCase("odAAtB")).isEqualTo("od_a_at_b");
        Assertions.assertThat(strategy.convertToSnakeCase("adtAAtn")).isEqualTo("adt_a_atn");
    }
}