package com.nexus.NexusShip.dto.response;

import com.nexus.NexusShip.model.ShipmentStatus;

import java.time.LocalDateTime;

public record ShipmentHistoryResponse(

        Long id,
        Long shipmentId,
        ShipmentStatus status,
        Long changedByUserID,
        String changedByUserName,
        LocalDateTime updatedAt,
        String note
) {}
