package dev.rm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.rm.model.Patient;
import dev.rm.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = getPatientById(id);

        if (existingPatient == null) {
            log.info("Patient with ID {} not found.", id);
            return null;
        }
        Optional.ofNullable(patient.getName()).ifPresent(existingPatient::setName);
        Optional.ofNullable(patient.getBirthDate()).ifPresent(existingPatient::setBirthDate);
        Optional.ofNullable(patient.getDiagnosis()).ifPresent(existingPatient::setDiagnosis);
        Optional.ofNullable(patient.getStatus()).ifPresent(existingPatient::setStatus);

        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }
}