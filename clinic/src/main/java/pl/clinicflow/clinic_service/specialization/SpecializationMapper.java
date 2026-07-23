package pl.clinicflow.clinic_service.specialization;

import org.springframework.stereotype.Component;

@Component
public class SpecializationMapper {

    public SpecializationResponse toResponse(final Specialization specialization) {
        return new SpecializationResponse(
                specialization.getId(),
                specialization.getCode(),
                specialization.getName(),
                specialization.getDescription(),
                specialization.isActive(),
                specialization.getCreatedAt(),
                specialization.getCreatedBy(),
                specialization.getModifiedAt(),
                specialization.getModifiedBy()
        );
    }
}
