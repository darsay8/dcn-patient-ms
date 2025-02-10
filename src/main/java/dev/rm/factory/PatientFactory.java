package dev.rm.factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.rm.model.Patient;
import dev.rm.model.PatientStatus;

public class PatientFactory {

    public static Patient createPatient(String name, String birthDateString, String diagnosis, PatientStatus status) {

        LocalDate birthDate = LocalDate.parse(birthDateString,
                DateTimeFormatter.ISO_DATE);

        return Patient.builder()
                .name(name)
                .birthDate(birthDate)
                .diagnosis(diagnosis)
                .status(status)
                .build();
    }
}
