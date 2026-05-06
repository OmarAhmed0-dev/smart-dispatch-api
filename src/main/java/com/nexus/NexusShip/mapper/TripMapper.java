package com.nexus.NexusShip.mapper;

import com.nexus.NexusShip.dto.response.ShipmentResponse;
import com.nexus.NexusShip.dto.response.TripResponse;
import com.nexus.NexusShip.model.Trip;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TripMapper {

    public TripResponse toResponse(Trip trip){
        ShipmentMapper mapper = new ShipmentMapper();
        List<ShipmentResponse> shipmentResponseList = trip.getShipmentList()
                .stream().map(mapper::toResponse).toList();
        return new TripResponse(
                trip.getId(),
                trip.getDriver().getId(),
                trip.getVehicle().getId(),
                trip.getStartedAt(),
                trip.getEndedAt(),
                trip.getStatus(),
                shipmentResponseList


        );

    }
}
