package dev.rm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rm.model.Patient;
import dev.rm.service.PatientService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        log.info("Getting all patients");

        List<Patient> patients = patientService.getAllPatients();

        if (patients.isEmpty()) {
            log.info("No patients found");
            return ResponseEntity.noContent().build();
        } else {
            log.info("Patients found");
            return ResponseEntity.ok(patients);
        }
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        log.info("Getting patient by id: {}", id);

        try {
            Patient patient = patientService.getPatientById(id);
            log.info("Patient: {}", patient);
            return ResponseEntity.ok(patient);
        } catch (RuntimeException e) {
            log.error("Patient not found with id: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }

    }

}
