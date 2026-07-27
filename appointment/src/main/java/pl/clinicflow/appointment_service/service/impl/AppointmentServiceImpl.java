package pl.clinicflow.appointment_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.clinicflow.appointment_service.service.AppointmentService;
import pl.clinicflow.appointment_service.service.client.ClinicFeignClient;
import pl.clinicflow.appointment_service.service.client.SpecializationResponse;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final ClinicFeignClient clinicFeignClient;


    @Override
    public ResponseEntity<SpecializationResponse> getData() {
        ResponseEntity<SpecializationResponse> specializationById = clinicFeignClient.getSpecializationById(UUID.randomUUID());

        return specializationById;
    }
}
