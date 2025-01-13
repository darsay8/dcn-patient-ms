package dev.rm.factory;

import dev.rm.model.Patient;

public class PatientFactory {
    public static Patient createPatient(String name, String birthDate, String diagnosis, String status) {
        return Patient.builder()
                .name(name)
                .birthDate(birthDate)
                .diagnosis(diagnosis)
                .status(status)
                .build();
    }
}
