package dev.rm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rm.model.Patient;

public interface Repository extends JpaRepository<Patient, Long> {

}
