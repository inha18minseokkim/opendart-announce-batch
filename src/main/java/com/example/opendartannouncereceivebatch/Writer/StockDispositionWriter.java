package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceStockDisposition;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceStockDispositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockDispositionWriter implements EssentialWriter{
    private final AnnounceStockDispositionRepository repository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceStockDisposition) essentialReport);
        return 1;
    }
}
