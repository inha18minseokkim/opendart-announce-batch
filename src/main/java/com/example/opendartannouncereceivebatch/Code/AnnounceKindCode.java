package com.example.opendartannouncereceivebatch.Code;

import com.example.opendartannouncereceivebatch.DTO.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import lombok.Getter;

@Getter
public enum AnnounceKindCode {
    PAIDINCREASE("https://opendart.fss.or.kr/api/piicDecsn.json",AnnouncePaidIncreaseElement.class, AnnouncePaidIncrease.class);
    /*호출 할 uri 저장*/
    String uri;
    /*response 시 list를 명세한 response객체*/
    Class<? extends Object> responseClass;
    /*entity 사용 객체*/
    Class<? extends Object> entityClass;

    AnnounceKindCode(String uri, Class<? extends Object> responseClass, Class<? extends Object> entityClass) {
        this.uri = uri;
        this.responseClass = responseClass;
        this.entityClass = entityClass;
    }
}
