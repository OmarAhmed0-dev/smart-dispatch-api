package com.nexus.NexusShip.controller;

import com.nexus.NexusShip.dto.request.DriverRegistrationRequest;
import com.nexus.NexusShip.dto.response.DriverResponse;
import com.nexus.NexusShip.dto.update.UserUpdateRequest;
import com.nexus.NexusShip.service.DriverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    //Get All drivers
    @GetMapping
    public ResponseEntity<List<DriverResponse>> getAllDrivers() {
        return ResponseEntity.ok(driverService.findAllDrivers());
    }
    //Get Driver by id
    @GetMapping("/{id}")
    public ResponseEntity<DriverResponse> getDriverById(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.findDriverById(id));
    }

    //Register a Driver
    @PostMapping("/register")
    public ResponseEntity<DriverResponse> registerDriver(@Valid @RequestBody DriverRegistrationRequest request) {
        return new ResponseEntity<>(driverService.registerDriver(request), HttpStatus.CREATED);
    }

    //Update a Driver
    @PutMapping("/{id}")
    public ResponseEntity<DriverResponse> updateDriver(@PathVariable Long id , @Valid @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(driverService.updateDriver(id , request));
    }

    //Delete a Driver
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }

}
