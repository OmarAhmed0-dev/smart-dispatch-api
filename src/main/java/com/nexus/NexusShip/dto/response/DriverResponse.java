package com.nexus.NexusShip.dto.response;

public record DriverResponse (
        Long id,
        String firstName,
        String lastName,
        double rating
){}
