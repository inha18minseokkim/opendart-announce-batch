package com.example.opendartannouncereceivebatch.Repository;

import com.example.opendartannouncereceivebatch.Entity.AnnouncePaidIncrease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncePaidIncreaseRepository extends JpaRepository<AnnouncePaidIncrease,Long> {
}
