package com.example.opendartannouncereceivebatch.Reader;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

public interface AnnounceDefaultReader {
    @Transactional
    Stream<AnnounceDefault> getAnnounceList(String beginDate, String endDate);
}
