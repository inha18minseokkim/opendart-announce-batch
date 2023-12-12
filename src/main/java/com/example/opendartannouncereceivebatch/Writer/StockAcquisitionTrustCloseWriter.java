package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceStockAcquisitionTrustClose;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceStockAcquisitionTrustCloseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StockAcquisitionTrustCloseWriter implements EssentialWriter{
    private final AnnounceStockAcquisitionTrustCloseRepository repository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceStockAcquisitionTrustClose) essentialReport);
        return 1;
    }
}
