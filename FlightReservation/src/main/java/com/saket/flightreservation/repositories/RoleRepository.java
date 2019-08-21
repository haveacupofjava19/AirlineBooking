package com.saket.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saket.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
