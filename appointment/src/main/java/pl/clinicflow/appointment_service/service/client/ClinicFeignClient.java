package pl.clinicflow.appointment_service.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("clinic")
public interface ClinicFeignClient {
    @GetMapping(value = "/api/specializations/{id}", consumes = "application/json")
    public ResponseEntity<SpecializationResponse> getSpecializationById(@PathVariable final UUID id);
}
