package com.example.opendartannouncereceivebatch.Code;

import com.example.opendartannouncereceivebatch.DTO.AnnouncePaidIncreaseElement;
import com.example.opendartannouncereceivebatch.DTO.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Mapper.AnnouncePaidIncreaseMapper;
import com.example.opendartannouncereceivebatch.Writer.EssentialWriter;
import com.example.opendartannouncereceivebatch.Writer.PaidIncreaseWriter;
import lombok.Getter;

@Getter
public enum AnnounceKindCode {
    PAIDINCREASE("https://opendart.fss.or.kr/api/piicDecsn.json",AnnouncePaidIncreaseElement.class,
            AnnouncePaidIncrease.class, AnnouncePaidIncreaseMapper.class, PaidIncreaseWriter.class);
    /*호출 할 uri 저장*/
    String uri;
    /*response 시 list를 명세한 response객체*/
    Class<? extends EssentialResponseElement> responseClass;
    /*entity 사용 객체*/
    Class<? extends EssentialReport> entityClass;
    /*ResponseElement -> Entity 매핑 인터페이스 클래스 타입*/
    Class<?> mapperInterface;
    /*Repository 접근하는 EssentialWriter클래스*/
    Class<? extends EssentialWriter> essentialWriter;


    AnnounceKindCode(String uri, Class<? extends EssentialResponseElement> responseClass,
                     Class<? extends EssentialReport> entityClass, Class<?> mapperInterface,
                        Class<? extends EssentialWriter> essentialWriter) {
        this.uri = uri;
        this.responseClass = responseClass;
        this.entityClass = entityClass;
        this.mapperInterface = mapperInterface;
        this.essentialWriter = essentialWriter;
    }
}
