package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnouncePaidIncreaseRepository;
import org.springframework.stereotype.Service;


@Service
public class PaidIncreaseWriter implements EssentialWriter {
    private final AnnouncePaidIncreaseRepository announcePaidIncreaseRepository;

    public PaidIncreaseWriter(AnnouncePaidIncreaseRepository announcePaidIncreaseRepository) {
        this.announcePaidIncreaseRepository = announcePaidIncreaseRepository;
    }

    @Override
    public Integer save(EssentialReport essentialReport) {
        AnnouncePaidIncrease announcePaidIncrease = (AnnouncePaidIncrease) essentialReport;
        AnnouncePaidIncrease save = announcePaidIncreaseRepository.save(announcePaidIncrease);
        return 1;
    }
}
