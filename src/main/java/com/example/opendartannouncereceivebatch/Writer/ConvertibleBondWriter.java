package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceConvertibleBond;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceConvertibleBondRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConvertibleBondWriter implements EssentialWriter{
    private final AnnounceConvertibleBondRepository repository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceConvertibleBond) essentialReport);
        return 1;
    }
}
