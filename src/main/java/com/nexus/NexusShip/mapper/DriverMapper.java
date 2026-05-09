package com.nexus.NexusShip.mapper;

import com.nexus.NexusShip.dto.request.DriverRegistrationRequest;
import com.nexus.NexusShip.dto.response.DriverResponse;
import com.nexus.NexusShip.model.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    public Driver toEntity(DriverRegistrationRequest request) {
        Driver driver = new Driver();
        driver.setFirstName(request.firstName());
        driver.setLastName(request.lastName());
        driver.setGender(request.gender());
        driver.setEmail(request.email());
        driver.setPassword(request.password());
        driver.setNationalId(request.nationalId());
        driver.setPhoneNumber(request.phoneNumber());
        driver.setLicenseNumber(request.licenseNumber());

        return driver;
    }


    public DriverResponse  toResponse(Driver driver) {
        return new DriverResponse(
                driver.getId(),
                driver.getFirstName(),
                driver.getLastName(),
                driver.getRating()
        );
    }
}
