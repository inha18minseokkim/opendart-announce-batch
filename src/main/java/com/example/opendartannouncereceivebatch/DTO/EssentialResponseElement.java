package com.example.opendartannouncereceivebatch.DTO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public interface EssentialResponseElement {
    public default EssentialResponseElement getRefinedElement() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //EssentialElement를 상속받는 하위클래스 인스턴스 생성
        EssentialResponseElement essentialResponseElement = this.getClass().getConstructor().newInstance();
        //각 필드에서 셋팅해줌
        for(Field field : this.getClass().getDeclaredFields()) {
            if(field.getType().equals(String.class)){
                field.setAccessible(true);
                String o = (String)field.get(this);
                if(o == null) continue;
                field.set(essentialResponseElement,o.replace("-","")
                        .replace(",","").trim());
            }
        }
        return essentialResponseElement;
    }
}
