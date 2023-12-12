package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceStartingSuit;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceStartingSuitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StartingSuitWriter implements EssentialWriter{
    private final AnnounceStartingSuitRepository repository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceStartingSuit) essentialReport);
        return 1;
    }
}
