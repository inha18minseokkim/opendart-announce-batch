package com.example.opendartannouncereceivebatch.Reader;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import com.example.opendartannouncereceivebatch.Repository.AnnounceDefaultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class AnnounceDefaultReaderImpl implements AnnounceDefaultReader{
    private final AnnounceDefaultRepository announceDefaultRepository;
    @Override
    @Transactional
    public Stream<AnnounceDefault> getAnnounceList(String beginDate, String endDate) {
        LocalDate localBeginDate = LocalDate.parse(beginDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate localEndDate =  LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return announceDefaultRepository.findByReceptDateBetween(localBeginDate,localEndDate);
    }
}
