package com.example.opendartannouncereceivebatch.Business;

import com.example.opendartannouncereceivebatch.Code.AnnounceKindCode;
import com.example.opendartannouncereceivebatch.DTO.AnnounceEssentialResponse;
import com.example.opendartannouncereceivebatch.DTO.EssentialResponseElement;
import com.example.opendartannouncereceivebatch.Entity.EssentialReport;
import com.example.opendartannouncereceivebatch.Mapper.EssentialMapper;
import com.example.opendartannouncereceivebatch.Writer.EssentialWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
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

    private final ApplicationContext applicationContext;

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
        if(list == null || list.isEmpty()){
            log.info(String.format("%s 에 대한 %s ~ %s 동안 %s 이벤트 없음",corpCode,beginDate,endDate,announceKindCode.getClass()));
            return Stream.empty();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        log.info(list.toString());
        return list.stream().map(object -> objectMapper.convertValue(object, responseClass));
    }
    public Stream<? extends EssentialReport> convertToEntity(Stream<? extends EssentialResponseElement> elementStream,
                                                             AnnounceKindCode announceKindCode) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        EssentialMapper essentialMapper = (EssentialMapper) announceKindCode.getMapperInterface().getConstructors()[0].newInstance();
        return elementStream.map((essentialMapper::from));
    }
    public Integer saveRepository(Stream<? extends EssentialReport> stream, AnnounceKindCode announceKindCode) {
        //announceKindCode에 있는 EssentialWriter 타입 빈 로딩
        log.info(announceKindCode.getEssentialWriter().toString() + " 빈 호출");

        EssentialWriter essentialWriter = applicationContext.getBean(announceKindCode.getEssentialWriter());

        //각각의 스트림 저장
        return stream.map((essentialReport -> essentialWriter.save(essentialReport)))
                .reduce(Integer::sum).orElse(0);
    }

}
