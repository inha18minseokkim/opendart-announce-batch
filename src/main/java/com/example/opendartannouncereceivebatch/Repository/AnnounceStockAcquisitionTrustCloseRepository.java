package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceStockAcquisitionTrustClose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnnounceStockAcquisitionTrustCloseRepository extends JpaRepository<AnnounceStockAcquisitionTrustClose,Long> {
}
