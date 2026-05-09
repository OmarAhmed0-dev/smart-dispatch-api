package com.nexus.NexusShip.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timeStamp,
        String message,
        int statusCode
) {}
