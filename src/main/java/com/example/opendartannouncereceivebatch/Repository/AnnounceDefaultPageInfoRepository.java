package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefaultPageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AnnounceDefaultPageInfoRepository extends JpaRepository<AnnounceDefaultPageInfo,Long> {
    Optional<AnnounceDefaultPageInfo> findByRceptDt(LocalDate rceptDt);
}
