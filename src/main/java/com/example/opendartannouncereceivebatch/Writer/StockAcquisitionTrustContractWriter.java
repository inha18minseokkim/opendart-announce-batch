package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceStockAcquisitionTrustContract;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceStockAcquisitionTrustContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockAcquisitionTrustContractWriter implements EssentialWriter{
    private final AnnounceStockAcquisitionTrustContractRepository repository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceStockAcquisitionTrustContract) essentialReport);
        return 1;
    }
}
