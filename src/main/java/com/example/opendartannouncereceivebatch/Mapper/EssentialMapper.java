package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.ListElement.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public interface EssentialMapper {
    org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EssentialMapper.class);
    public default EssentialReport from(EssentialResponseElement element){
        return null;
    }
    public default <S, T> T mapObjects(S source, Class<T> targetType) throws IllegalAccessException, InstantiationException {
        if (source == null) {
            return null;
        }

        T target = targetType.newInstance();
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = targetType.getDeclaredFields();

        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true);

            for (Field targetField : targetFields) {
                targetField.setAccessible(true);

                if (sourceField.getName().equals(targetField.getName())) {
                    Object value = sourceField.get(source);
                    if (value != null) {
                        Object convertedValue = convert(value, targetField.getType());
                        targetField.set(target, convertedValue);
                    }
                    break;
                }
            }
        }

        return target;
    }

    public default Object convert(Object value, Class<?> targetType) {
        try {
            if (targetType.equals(String.class)) {
                return value.toString();
            } else if (targetType.equals(Long.class) || targetType.equals(long.class)) {
                return Long.parseLong(value.toString());
            } else if (targetType.equals(Double.class) || targetType.equals(double.class)) {
                return Double.parseDouble(value.toString());
            } else if (targetType.equals(LocalDate.class)) {
                // Assume source is a String for simplicity
                return LocalDate.parse(value.toString(), DateTimeFormatter.ofPattern("yyyyMMdd"));
            }
            // Add more type conversions as needed

            // If no conversion found, return the original value
            return value;
        } catch(NumberFormatException e){
            //string ""으로 들어오는경우 그냥 null return 좀 위험하긴함.
            log.error("오류 발생 {}, 원본값 {} , 변환대상타입 {}",e.toString(),value,targetType);
            return null;
        } catch (DateTimeParseException e){
            //string ""으로 들어오는경우 그냥 null
            log.error("오류 발생 {}, 원본값 {} , 변환대상타입 {}",e.toString(),value,targetType);
            return null;
        } catch(NullPointerException e){
            log.error("Null오류 발생 {}, 원본값 {} , 변환대상타입 {}",e.toString(),value,targetType);
            throw new IllegalStateException("null on map");
        }
    }

}
