package dev.rm.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.rm.model.Patient;
import dev.rm.repository.PatientRepository;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

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
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        existingPatient.setName(patient.getName());
        existingPatient.setBirthDate(patient.getBirthDate());
        existingPatient.setDiagnosis(patient.getDiagnosis());
        existingPatient.setStatus(patient.getStatus());
        existingPatient.setUpdatedAt(LocalDateTime.now());
        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
