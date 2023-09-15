package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnnounceDefaultRepositoryTest {
    @Autowired
    private AnnounceDefaultRepository announceDefaultRepository;

    @Test
    public void announce_test() {
        List<AnnounceDefault> announceDefaultList = announceDefaultRepository.findAll();
        System.out.println(announceDefaultList.size());
        assertNotEquals(announceDefaultList.size(),0);
    }

}