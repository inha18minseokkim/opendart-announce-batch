package com.example.opendartannouncereceivebatch.Reader;

import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Repository.CorpInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CorpCodeReaderTestImpl implements CorpCodeReader{
    private CorpInfoRepository corpInfoRepository;

    //corpInfoList 에 해당하는 기업 이름이 있는 경우 corpList 리턴
    @Override
    public List<CorpInfo> getTargetCorpList(List<String> corpInfoList) {
        return corpInfoList.stream().map((corpInfo) -> corpInfoRepository.findFirstByCorpName(corpInfo))
                .filter((optionalCorpInfo) -> optionalCorpInfo.isPresent())
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
