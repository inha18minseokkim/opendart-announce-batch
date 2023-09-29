package com.example.opendartannouncereceivebatch.Mapper;

import com.example.opendartannouncereceivebatch.DTO.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;

public interface EssentialMapper {
    public EssentialReport from(EssentialResponseElement element);
}
