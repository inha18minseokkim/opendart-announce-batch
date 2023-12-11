package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceStockAcquisition;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceStockAcquisitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockAcquisitionWriter implements EssentialWriter{
    private final AnnounceStockAcquisitionRepository repository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceStockAcquisition) essentialReport);
        return 1;
    }
}
