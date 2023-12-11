package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceCapitalReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceCapitalReductionRepository extends JpaRepository<AnnounceCapitalReduction,Long> {
}
