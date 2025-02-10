package dev.rm.init;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.rm.factory.PatientFactory;
import dev.rm.model.Patient;
import dev.rm.model.PatientStatus;
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

        Patient patient1 = PatientFactory.createPatient("Ethan Carter", "1987-03-15", "Hypertension",
                PatientStatus.GOOD);
        Patient patient2 = PatientFactory.createPatient("Lila Bennett", "1992-07-22", "Infarct",
                PatientStatus.CRITICAL);
        Patient patient3 = PatientFactory.createPatient("Clara Simmons", "1985-11-08", "Pneumonia",
                PatientStatus.GOOD);

        Patient patient4 = PatientFactory.createPatient("Jasper Moreno", "1975-01-01", "Flu",
                PatientStatus.GOOD);

        Patient patient5 = PatientFactory.createPatient("Sarah Turner", "1982-03-25", "Asthma", PatientStatus.CRITICAL);

        Patient patient6 = PatientFactory.createPatient("Emily Davis", "2000-01-22", "Migraine", PatientStatus.GOOD);

        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3, patient4, patient5, patient6));

    }

}
