package com.nexus.NexusShip.mapper;

import com.nexus.NexusShip.dto.request.VehicleRegistrationRequest;
import com.nexus.NexusShip.dto.response.VehicleResponse;
import com.nexus.NexusShip.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public Vehicle toEntity(VehicleRegistrationRequest request) {
        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleType(request.vehicleType());
        vehicle.setMaxWeight(request.vehicleType().getMaxWeight());
        vehicle.setMaxVolume(request.vehicleType().getMaxVolume());

        return vehicle;

    }

    public VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getVehicleType(),
                vehicle.getMaxWeight(),
                vehicle.getMaxVolume()
        );
    }
}
