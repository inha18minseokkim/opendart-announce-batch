package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultResponse;
import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Repository.CorpInfoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class DefaultAnnounceApiReceive implements Tasklet {
    CorpInfoRepository corpInfoRepository;
    private String opendartSecret = "bfb1272f4109ed5e959ff0b82b40bb08291ffb45";
    public DefaultAnnounceApiReceive(CorpInfoRepository corpInfoRepository) {
        this.corpInfoRepository = corpInfoRepository;
    }

    public Mono<AnnounceDefaultResponse> getCurrentCorpAnnounce(CorpInfo corpInfo,String beginDate,String endDate) {
        String url = UriComponentsBuilder.fromHttpUrl("https://opendart.fss.or.kr/api/list.json")
                .queryParam("crtfc_key",opendartSecret)
                .queryParam("corp_code",corpInfo.getCorpCode())
                .queryParam("bgn_de",beginDate)
                .queryParam("end_de",endDate)
                .queryParam("last_report_at","Y")
                .build().toUriString();
        log.info(url);
        WebClient webClient = WebClient.builder().baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_ATOM_XML_VALUE).build()
                ;
        Mono<AnnounceDefaultResponse> result = webClient.get().retrieve()
                .bodyToMono(AnnounceDefaultResponse.class);
        log.info(result.toString());
        return result;
    }
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<CorpInfo> corpInfoList = corpInfoRepository.findAll();
//        corpInfoList.stream().map(this::getCurrentCorpAnnounce)
//                ;


        return null;
    }
}
