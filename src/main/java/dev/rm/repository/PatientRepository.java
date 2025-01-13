package dev.rm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.rm.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
