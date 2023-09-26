package com.example.opendartannouncereceivebatch.Code;

import com.example.opendartannouncereceivebatch.Business.ApiReceive;
import com.example.opendartannouncereceivebatch.DTO.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;

public enum AnnounceKindCode {
    PAIDINCREASE("https://opendart.fss.or.kr/api/piicDecsn.json",AnnouncePaidIncreaseElement.class, AnnouncePaidIncrease.class);
    String uri;
    Class<? extends Object> targetClass;
    Class<? extends Object> entityClass;

    AnnounceKindCode(String url, Class<? extends Object> targetClass, Class<? extends Object> entityClass) {
        this.uri = uri;
        this.targetClass = targetClass;
        this.entityClass = entityClass;
    }
}
