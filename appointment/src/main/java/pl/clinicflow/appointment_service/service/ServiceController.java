package pl.clinicflow.appointment_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.clinicflow.appointment_service.service.client.SpecializationResponse;

@RestController
@RequiredArgsConstructor
public class ServiceController {

    private final AppointmentService appointmentService;

    @GetMapping
    public void getClientData() {
        ResponseEntity<SpecializationResponse> data = appointmentService.getData();
        System.out.println(data);
    }
}
