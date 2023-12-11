package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceBondWithWarrant;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceBondWithWarrantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BondWithWarrantWriter implements EssentialWriter{

    private final AnnounceBondWithWarrantRepository repository;

    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceBondWithWarrant) essentialReport);
        return 1;
    }
}
