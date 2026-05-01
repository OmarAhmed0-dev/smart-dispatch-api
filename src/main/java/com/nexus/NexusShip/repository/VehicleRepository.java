package com.nexus.NexusShip.repository;

import com.nexus.NexusShip.model.Vehicle;
import com.nexus.NexusShip.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


    Optional<Vehicle> findByVehicleType(VehicleType vehicleType);


    @Query("SELECT v from Vehicle v where v.vehicleType = :vehicleType " +
            "and v.id NOT IN (select t.vehicle.id from Trip t where t.status = 'ACTIVE')")
    Optional<Vehicle> findByAvailableVehicleType(VehicleType vehicleType);



}
