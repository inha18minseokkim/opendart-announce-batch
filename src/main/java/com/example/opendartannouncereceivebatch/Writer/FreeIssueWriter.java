package com.example.opendartannouncereceivebatch.Writer;

import com.example.opendartannouncereceivebatch.Entity.AnnounceFreeIssue;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Repository.AnnounceFreeIssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FreeIssueWriter implements EssentialWriter{
    private final AnnounceFreeIssueRepository announceFreeIssueRepository;
    @Override
    public Integer save(EssentialReport essentialReport) {
        AnnounceFreeIssue announceFreeIssue = (AnnounceFreeIssue) essentialReport;
        announceFreeIssueRepository.save(announceFreeIssue);
        return 1;
    }
}
