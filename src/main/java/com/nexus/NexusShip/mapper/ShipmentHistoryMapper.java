package com.nexus.NexusShip.mapper;

import com.nexus.NexusShip.dto.response.ShipmentHistoryResponse;
import com.nexus.NexusShip.model.ShipmentHistory;
import org.springframework.stereotype.Component;

@Component
public class ShipmentHistoryMapper {

    public ShipmentHistoryResponse toResponse(ShipmentHistory history){
        return new ShipmentHistoryResponse (
                history.getId(),
                history.getShipment().getId(),
                history.getStatus(),
                history.getWhoMakeTheChange().getId(),
                history.getWhoMakeTheChange().getFirstName(),
                history.getUpdatedAt(),
                history.getNote()

        );
    }
}
