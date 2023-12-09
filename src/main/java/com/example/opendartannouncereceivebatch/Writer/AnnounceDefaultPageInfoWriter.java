package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefaultPageInfo;
import com.example.opendartannouncereceivebatch.Repository.AnnounceDefaultPageInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class AnnounceDefaultPageInfoWriter {
    private final AnnounceDefaultPageInfoRepository repository;

    public void saveCurrentPage(LocalDate currentDate, Integer pageCount){
        AnnounceDefaultPageInfo announceDefaultPageInfo = AnnounceDefaultPageInfo.builder().rceptDt(currentDate).currentCount(pageCount).build();
        repository.save(announceDefaultPageInfo);
    }

}
