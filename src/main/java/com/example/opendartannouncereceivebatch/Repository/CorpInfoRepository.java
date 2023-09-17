package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.CorpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CorpInfoRepository extends JpaRepository<CorpInfo, Long> {
    Optional<CorpInfo> findFirstByCorpName(String corpName);
}
