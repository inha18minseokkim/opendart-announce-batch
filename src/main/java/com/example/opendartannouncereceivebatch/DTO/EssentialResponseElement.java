package com.example.opendartannouncereceivebatch.DTO;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public interface EssentialResponseElement {
    public default EssentialResponseElement getRefinedElement() {
        //EssentialElement를 구현하는 하위클래스 인스턴스 생성
        EssentialResponseElement essentialResponseElement = null;
        try {
            essentialResponseElement = this.getClass().getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        //각 필드에서 셋팅해줌(하위 클래스의 필드를 따름)
        for(Field field : this.getClass().getDeclaredFields()) {
            if(field.getType().equals(String.class)){
                field.setAccessible(true);
                try {
                    String o = (String)field.get(this);
                    if(o == null) continue;
                    //숫자 및 없는 정보는 null로 만들기 위한 정제작업
                    field.set(essentialResponseElement,o.replace("-","")
                                    .replace("년","")
                                    .replace("월","")
                                    .replace("일","")
                                    .replace(" ","")
                            .replace(",","").trim());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //this 가 아닌 복사된 객체 리턴(함수형 인터페이스 사용 기대)
        return essentialResponseElement;
    }
}
