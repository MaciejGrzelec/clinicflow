package pl.clinicflow.clinic_service.specialization;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/specializations")
public class SpecializationController {
    private final SpecializationService specializationService;

    @PostMapping
    public ResponseEntity<SpecializationResponse> createSpecialization(
            @Valid @RequestBody final CreateSpecializationRequest request,
            final UriComponentsBuilder uriBuilder) {
        final SpecializationResponse specializationResponse = specializationService.create(request);

        final URI location = uriBuilder
                .path("/api/specializations/{id}")
                .buildAndExpand(specializationResponse.id())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(specializationResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecializationResponse> getById(@PathVariable final UUID id) {
        final SpecializationResponse specialization = specializationService.getById(id);

        return ResponseEntity.ok(specialization);
    }

    @GetMapping
    public ResponseEntity<List<SpecializationResponse>> getAll(
            @RequestParam(defaultValue = "false")
            final boolean activeOnly) {
        final List<SpecializationResponse> specializations = specializationService.getAll(activeOnly);

        return ResponseEntity.ok(specializations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecializationResponse> update(
            @PathVariable final UUID id,
            @Valid @RequestBody
            final CreateSpecializationRequest request) {
        final SpecializationResponse specialization = specializationService.update(id, request);

        return ResponseEntity.ok(specialization);
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<SpecializationResponse> activate(@PathVariable final UUID id) {
        final SpecializationResponse specialization = specializationService.activate(id);

        return ResponseEntity.ok(specialization);
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<SpecializationResponse> deactivate(@PathVariable final UUID id) {
        final SpecializationResponse specialization = specializationService.deactivate(id);

        return ResponseEntity.ok(specialization);
    }
}
