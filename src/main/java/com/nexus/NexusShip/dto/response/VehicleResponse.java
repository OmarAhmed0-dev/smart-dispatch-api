package com.nexus.NexusShip.dto.response;

import com.nexus.NexusShip.model.VehicleType;

public record VehicleResponse (
        Long id,
        VehicleType vehicleType,
        double maxWeight,
        double maxHeight
){}
