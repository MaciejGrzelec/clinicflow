package pl.clinicflow.clinic_service.specialization;

import java.time.Instant;
import java.util.UUID;

public record SpecializationResponse(
        UUID id,
        String code,
        String name,
        String description,
        boolean active,
        Instant createdAt,
        String createdBy,
        Instant modifiedAt,
        String modifiedBy) {
}
