package com.example.opendartannouncereceivebatch.Reader;

import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Repository.CorpInfoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CorpCodeReaderImpl implements CorpCodeReader{
    private CorpInfoRepository corpInfoRepository;
    @Override
    public List<CorpInfo> getTargetCorpList(List<String> corpNameList) {
        return corpInfoRepository.findAll();
    }
}
