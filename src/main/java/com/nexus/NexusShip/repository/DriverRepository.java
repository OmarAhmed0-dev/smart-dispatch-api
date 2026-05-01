package com.nexus.NexusShip.repository;

import com.nexus.NexusShip.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByLicenseNumber(Long licenseNumber);

    @Query("select d from Driver d where d.rating >= :minRating")
    List<Driver> findTopRatedDriver(@Param("minRating") double minRating);

    @Query("SELECT d from Driver d join d.tripList t " +
            "where d.rating >= :minRating " +
            "AND t.status != 'ACTIVE'" +
            "AND d.id NOT IN (SELECT t2.driver.id FROM Trip t2 where t2.status = 'ACTIVE')")
    List<Driver>findAvailableHighRatedDriver(@Param("minRating") double minRating);

    @Query("select d from Driver d join d.tripList t " +
            "where t.status != 'ACTIVE'" +
            "AND d.id NOT IN (SELECT t2.driver.id FROM Trip t2 where t2.status = 'ACTIVE')")
    List<Driver>findAvailableDriver();




}
