package com.nexus.NexusShip.repository;

import com.nexus.NexusShip.model.Sender;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO sender (id) VALUES (:id)", nativeQuery = true)
    void insertSenderRole(@Param("id") Long id);


}
