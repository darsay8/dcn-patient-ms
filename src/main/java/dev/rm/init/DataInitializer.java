package dev.rm.init;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.rm.factory.PatientFactory;
import dev.rm.model.Patient;
import dev.rm.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private final PatientRepository patientRepository;

    public DataInitializer(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        log.info("Initializing data...");

        Patient patient1 = PatientFactory.createPatient("Juan Pérez", "1990-01-01", "Hypertension", "Good");
        Patient patient2 = PatientFactory.createPatient("María López", "1990-01-01", "Infarct", "Critical");
        Patient patient3 = PatientFactory.createPatient("Carlos Méndez", "1990-01-01", "Pneumonia", "Good");
        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3));

    }

}
