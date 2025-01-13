package dev.rm.service;

import java.util.List;
import dev.rm.model.Patient;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient savePatient(Patient patient);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);

}
