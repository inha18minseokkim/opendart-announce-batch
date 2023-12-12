package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StockAcquisitionTrustCloseWriter implements EssentialWriter{
    @Override
    public Integer save(EssentialReport essentialReport) {
        return null;
    }
}
