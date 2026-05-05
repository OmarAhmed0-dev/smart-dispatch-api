package com.nexus.NexusShip.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;

public record ShipmentRequest(

        @NotNull(message = "Sender ID required")
        Long senderId,

        @NotNull(message = "Weight is required")
        double weight,

        @NotNull(message = "Volume is required")
        double volume,

        @NotNull(message = "Shipment value is required")
        BigDecimal shipmentValue,

        @NotNull(message = "Pick up location is required")
        Point pickUpLocation,

        @NotNull(message = "Destination location is required")
        Point destinationLocation,


        // Creating a receiver Object if not Exist
        // if the receiver exist based on the phone number we will assign th shipment to him
        @NotBlank(message = "Receiver phone number is required")
        @Pattern(
                regexp = "^(0020|\\+20|0)?1[0125][0-9]{8}$",
                message = "Please enter a valid Egyptian mobile number"
        )
        String receiverPhoneNumber,

        boolean shipmentInsurance
) {}
