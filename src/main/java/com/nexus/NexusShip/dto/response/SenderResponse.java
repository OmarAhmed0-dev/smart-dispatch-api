package com.nexus.NexusShip.dto.response;

import com.nexus.NexusShip.model.Gender;

public record SenderResponse(
        Long id,
        String firstName,
        String lastName,
        Gender gender,
        String email,
        String phoneNumber

) {}
