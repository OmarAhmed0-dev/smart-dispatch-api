package com.nexus.NexusShip.dto.response;

import com.nexus.NexusShip.model.AdminRole;

import java.time.LocalDateTime;

public record AdminResponse(
        Long id,
        String firstName,
        String lastName,
        LocalDateTime hireDate,
        AdminRole adminRole
) {
}
