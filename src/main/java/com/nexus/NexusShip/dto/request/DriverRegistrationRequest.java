package com.nexus.NexusShip.dto.request;

import com.nexus.NexusShip.model.Gender;
import jakarta.validation.constraints.*;

public record DriverRegistrationRequest(
        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotNull(message = "Gender is required")
        Gender gender,

        @NotBlank(message = "Email name is required")
        @Email
        String email,

        @NotBlank
        @Size(min = 8 , message = "Password must be at least 8 characters")
        String password,

        @NotBlank
        @Size(min = 14 , max = 14 , message = "National ID must be exactly 14 characters")
        @Pattern(regexp = "\\d{14}", message = "National ID must contain only digits")
        String nationalId,

        @NotBlank
        @Pattern(
        regexp = "^(0020|\\+20|0)?1[0125][0-9]{8}$",
        message = "Please enter a valid Egyptian mobile number"
        )
        String phoneNumber,


        @NotBlank
        @Size(min = 14 , max = 14 , message = "License number must be exactly 14 characters")
        @Pattern(regexp = "\\d{14}", message = "License number must contain only digits")
        String licenseNumber

) {}
