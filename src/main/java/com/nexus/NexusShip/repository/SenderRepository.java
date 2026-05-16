package com.nexus.NexusShip.repository;

import com.nexus.NexusShip.model.Sender;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO sender (sender_id) VALUES (:id)", nativeQuery = true)
    void insertSenderRole(@Param("id") Long id);

    @Query(value = "select sender_id from sender where sender_id =:id",nativeQuery = true)
    Optional<Long> findSenderIdByIdEveryWhere(@Param("id") Long id);

    @Query(value = "SELECT u.*, s.* FROM sender s JOIN users u ON s.sender_id = u.id WHERE s.sender_id = :id", nativeQuery = true)
    Optional<Sender> findSenderByIdEveryWhere(@Param("id") Long id);


}
