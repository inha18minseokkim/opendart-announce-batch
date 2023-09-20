package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultResponse;
import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Reader.CorpCodeReader;
import com.example.opendartannouncereceivebatch.Repository.CorpInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApiReceive {

    @Value("${opendart.secret}")
    private String opendartSecret;

    /*특정 회사에 대해 beginDate ~ endDate까지의 기본 공시정보 호출*/
    public Mono<AnnounceDefaultResponse> getCurrentCorpAnnounce(Optional<CorpInfo> corpInfo, String beginDate, String endDate, Integer pageNumber) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("https://opendart.fss.or.kr/api/list.json")
                .queryParam("crtfc_key",opendartSecret)
                .queryParam("bgn_de",beginDate)
                .queryParam("end_de",endDate)
                .queryParam("last_report_at","Y")
                .queryParam("page_no",pageNumber)
                .queryParam("page_count",100);
        if(corpInfo.isPresent())
            uriComponentsBuilder = uriComponentsBuilder.queryParam("corp_code",corpInfo.get().getCorpCode());

        String url = uriComponentsBuilder.build().toUriString();
        log.info(url);
        WebClient webClient = WebClient.builder().baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_ATOM_XML_VALUE).build();
        Mono<AnnounceDefaultResponse> result = webClient.get().retrieve()
                .bodyToMono(AnnounceDefaultResponse.class);

        log.info(result.toString());
        return result;
    }
    /*
     * 특정 회사들에 대한 공시정보 가져오는 기능(beginDate ~ endDate)
     * targetCorpList에 회사이름 넣고 corpCodeReader에 corpCodeReaderTestImpl넣으면 특정 회사들에 대한 공시정보 가져옴
     * targetCorpList에 빈 리스트 넣고 corpCodeReader에 corpCodeReaderImpl 넣으면 db에 있는 모든 회사들에 대한 정보 가져옴
     */
    public Stream<AnnounceDefaultElement> getAnnouncementList(CorpCodeReader corpCodeReader, List<String> targetCorpList, String beginDate, String endDate) {
        List<CorpInfo> corpInfoList = corpCodeReader.getTargetCorpList(targetCorpList);
        Stream<AnnounceDefaultElement> announceDefaultElementList = corpInfoList.parallelStream().map((CorpInfo corpInfo) -> {
            List<AnnounceDefaultResponse> tempResponse = new ArrayList<>();
            Integer pageNumber = 1;
            while (true) {
                AnnounceDefaultResponse block = this.getCurrentCorpAnnounce(Optional.ofNullable(corpInfo), beginDate, endDate, pageNumber).block();
                tempResponse.add(block);
                log.info(block.getTotal_page() + " : " + pageNumber);
                if(block.getTotal_page() == pageNumber) break;
                pageNumber++;
            }
            return tempResponse;
        }).flatMap(List::stream).map(AnnounceDefaultResponse::getList).flatMap(List::stream);
        return announceDefaultElementList;
    }
    /*
     * beginDate ~ endDate동안 모든 회사에 대한 공시정보 가져옴
     * */
    public Stream<AnnounceDefaultElement> getAnnouncementList(String beginDate,String endDate){
        List<AnnounceDefaultResponse> tempResponse = new ArrayList<>();
        Integer pageNumber = 1;
        while (true) {
            AnnounceDefaultResponse block = this.getCurrentCorpAnnounce(Optional.ofNullable(null), beginDate, endDate, pageNumber).block();
            tempResponse.add(block);
            log.info(block.getTotal_page() + " : " + pageNumber);
            if(block.getTotal_page() == pageNumber) break;
            pageNumber++;
        }
        log.info(tempResponse.size()+"");
        return tempResponse.stream().map(AnnounceDefaultResponse::getList)
                .flatMap(List::stream);
    }
}
