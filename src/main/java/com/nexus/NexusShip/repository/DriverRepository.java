package com.nexus.NexusShip.repository;

import com.nexus.NexusShip.model.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {


    Optional<Driver> findByLicenseNumber(String licenseNumber);

    @Query("select d from Driver d where d.rating >= :minRating")
    List<Driver> findTopRatedDriver(@Param("minRating") double minRating);

    @Query("SELECT d from Driver d join d.tripList t " +
            "where d.rating >= :minRating " +
            "AND t.status != 'ACTIVE'" +
            "AND d.id NOT IN (SELECT t2.driver.id FROM Trip t2 where t2.status = 'ACTIVE')")
    List<Driver> findAvailableHighRatedDriver(@Param("minRating") double minRating);

    @Query("select d from Driver d join d.tripList t " +
            "where t.status != 'ACTIVE'" +
            "AND d.id NOT IN (SELECT t2.driver.id FROM Trip t2 where t2.status = 'ACTIVE')")
    List<Driver> findAvailableDriver();

    @Query(value = "select u.* , d.*  from driver d join users u ON  d.driver_id = u.id WHERE d.driver_id = :id", nativeQuery = true)
    Optional<Driver> findByIdEverywhere(@Param("id") Long id);

    @Query(value = "select driver_id from driver where license_number =:licenseNumber" , nativeQuery = true)
    Optional<Long> findDriverIdByLicenseNumberEverywhere(@Param("licenseNumber") String licenseNumber);

    @Query(value = "SELECT driver_id FROM driver WHERE driver_id = :id", nativeQuery = true)
    Optional<Long> findDriverIdByIdEverywhere(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query(value = "INSERT into driver (driver_id,license_number ,rating,salary) values (:id ,:licenseNumber, :rating,:salary)", nativeQuery = true)
    void insertDriverRole(@Param("id") long id, @Param("licenseNumber") String licenseNumber,
                          @Param("rating") double rating , @Param("salary")BigDecimal salary);


}
