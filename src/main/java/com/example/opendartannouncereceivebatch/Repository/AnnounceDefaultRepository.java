package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnounceDefault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceDefaultRepository extends JpaRepository<AnnounceDefault, Long> {
}
