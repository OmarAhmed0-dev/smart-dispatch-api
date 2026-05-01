package com.nexus.NexusShip.repository;

import com.nexus.NexusShip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String email);

    Optional<User> findByNationalId(String nationalId);

    Boolean existsByNationalId(String nationalId);
}
