package com.example.opendartannouncereceivebatch.Reader;

import com.example.opendartannouncereceivebatch.Entity.CorpInfo;

import java.util.List;

public interface CorpCodeReader {
    List<CorpInfo> getTargetCorpList(List<String> corpNameList);
}
