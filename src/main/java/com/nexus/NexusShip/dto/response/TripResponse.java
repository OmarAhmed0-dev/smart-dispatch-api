package com.nexus.NexusShip.dto.response;

import com.nexus.NexusShip.model.Shipment;
import com.nexus.NexusShip.model.TripStatus;

import java.time.LocalDateTime;
import java.util.List;

public record TripResponse(

        Long id,
        Long driverId,
        Long vehicleId,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        TripStatus status,
        List<ShipmentResponse> shipmentList

) {}
