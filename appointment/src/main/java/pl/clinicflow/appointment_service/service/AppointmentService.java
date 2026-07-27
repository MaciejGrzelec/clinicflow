package pl.clinicflow.appointment_service.service;

import org.springframework.http.ResponseEntity;
import pl.clinicflow.appointment_service.service.client.SpecializationResponse;

public interface AppointmentService {
    ResponseEntity<SpecializationResponse> getData();
}
