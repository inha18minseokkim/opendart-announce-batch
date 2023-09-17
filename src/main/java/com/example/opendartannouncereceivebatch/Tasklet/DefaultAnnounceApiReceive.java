package com.example.opendartannouncereceivebatch.Tasklet;

import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultElement;
import com.example.opendartannouncereceivebatch.DTO.AnnounceDefaultResponse;
import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import com.example.opendartannouncereceivebatch.Reader.CorpCodeReader;
import com.example.opendartannouncereceivebatch.Reader.CorpCodeReaderImpl;
import com.example.opendartannouncereceivebatch.Repository.CorpInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class DefaultAnnounceApiReceive implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        //List<AnnounceDefaultElement> announcementList = getAnnouncementList(corpCodeReaderImpl,new ArrayList<>());

        //log.info(""+announceDefaultElementList.size());
        return RepeatStatus.FINISHED;
    }
}
