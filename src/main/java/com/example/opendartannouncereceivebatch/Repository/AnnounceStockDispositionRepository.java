package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceStockDisposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceStockDispositionRepository extends JpaRepository<AnnounceStockDisposition,Long> {
}
