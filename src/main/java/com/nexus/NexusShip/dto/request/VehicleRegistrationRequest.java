package com.nexus.NexusShip.dto.request;

import com.nexus.NexusShip.model.VehicleType;
import jakarta.validation.constraints.NotNull;

public record VehicleRegistrationRequest(

        @NotNull(message = "Vehicle type is required")
        VehicleType vehicleType

) {}
