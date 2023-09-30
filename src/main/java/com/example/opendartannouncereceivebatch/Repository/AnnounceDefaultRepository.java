package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface AnnounceDefaultRepository extends JpaRepository<AnnounceDefault, Long> {
    @Transactional
    Stream<AnnounceDefault> findByReceptDateBetween(LocalDate startDate, LocalDate endDate);
}
