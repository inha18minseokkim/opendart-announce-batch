package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceBondWithWarrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceBondWithWarrantRepository extends JpaRepository<AnnounceBondWithWarrant, Long> {
}
