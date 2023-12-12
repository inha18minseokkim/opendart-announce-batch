package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceStockAcquisitionTrustContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceStockAcquisitionTrustContractRepository extends JpaRepository<AnnounceStockAcquisitionTrustContract,Long> {
}
