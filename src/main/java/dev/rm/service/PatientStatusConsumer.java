package dev.rm.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import dev.rm.model.Patient;
import dev.rm.model.PatientMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientStatusConsumer {

    private final PatientService patientService;

    @RabbitListener(queues = "patientStatusQueue")
    public void receivePatientStatus(PatientMessage message) {
        log.info("Consuming message from patientStatusQueue: {}",
                message);

        Long patientId = Long.valueOf(message.getPatientId());

        Patient updatedPatient = patientService.updatePatient(patientId,
                createPatientFromMessage(message));

        if (updatedPatient != null) {
            log.info("Patient with ID: {} successfully updated.", patientId);
        } else {
            log.error("Failed to update patient with ID: {}", patientId);
        }
    }

    private Patient createPatientFromMessage(PatientMessage patientMessage) {
        Patient patient = new Patient();
        patient.setStatus(patientMessage.getStatus());
        return patient;
    }
}
