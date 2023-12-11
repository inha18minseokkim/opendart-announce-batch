package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceConvertibleBond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceConvertibleBondRepository extends JpaRepository<AnnounceConvertibleBond,Long> {
}
