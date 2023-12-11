package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceExchangeableBond;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceExchangeableBondRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeableBondWriter implements EssentialWriter{

    private final AnnounceExchangeableBondRepository repository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        repository.save((AnnounceExchangeableBond) essentialReport);
        return 1;
    }
}
