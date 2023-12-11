package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceCapitalReduction;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceCapitalReductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CapitalReductionWriter implements EssentialWriter{

    private final AnnounceCapitalReductionRepository repository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceCapitalReduction) essentialReport);
        return 1;
    }
}
