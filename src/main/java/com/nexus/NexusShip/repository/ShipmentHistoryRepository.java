package com.nexus.NexusShip.repository;

import com.nexus.NexusShip.model.ShipmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentHistoryRepository extends JpaRepository<ShipmentHistory, Long> {

    //Find full history for a shipment
    @Query("select h from ShipmentHistory h where h.shipment.id = :shipmentId order by h.updatedAt DESC")
    List<ShipmentHistory> findFullHistory(@Param("shipmentId") Long shipmentId);
}
