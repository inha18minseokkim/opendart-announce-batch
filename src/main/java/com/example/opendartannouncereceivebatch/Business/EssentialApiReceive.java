package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.Code.AnnounceKindCode;
import com.example.opendartannouncereceivebatch.DTO.AnnounceEssentialResponse;
import com.example.opendartannouncereceivebatch.DTO.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Mapper.EssentialMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class EssentialApiReceive {
    @Value("${opendart.secret}")
    private String opendartSecret;
    public Stream<? extends EssentialResponseElement> getEssentialAnnouncement(String beginDate, String endDate, String corpCode, AnnounceKindCode announceKindCode){
        Class<? extends EssentialResponseElement> responseClass = announceKindCode.getResponseClass();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(announceKindCode.getUri())
                .queryParam("crtfc_key",opendartSecret)
                .queryParam("bgn_de",beginDate)
                .queryParam("end_de",endDate)
                .queryParam("corp_code",corpCode);
        String url = uriComponentsBuilder.build().toUriString();
        log.info(url);
        WebClient webClient = WebClient.builder().baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_ATOM_XML_VALUE).build();
        Mono<AnnounceEssentialResponse> result = webClient.get().retrieve()
                .bodyToMono(AnnounceEssentialResponse.class);
        AnnounceEssentialResponse block = result.block();
        List<Object> list = block.getList();
        ObjectMapper objectMapper = new ObjectMapper();
        log.info(list.toString());
        return list.stream().map(object -> objectMapper.convertValue(object, responseClass));
    }
    public Stream<? extends EssentialReport> convertToEntity(Stream<? extends EssentialResponseElement> elementStream,
                                                             AnnounceKindCode announceKindCode) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        EssentialMapper essentialMapper = (EssentialMapper) announceKindCode.getMapperInterface().getConstructors()[0].newInstance();
        return elementStream.map((essentialMapper::from));
    }

}
