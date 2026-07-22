package pl.clinicflow.clinic_service.specialization;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSpecializationRequest(

        @NotBlank(message = "Specialization code is required")
        @Size(
                max = 50,
                message = "Specialization code cannot exceed 50 characters"
        )
        String code,

        @NotBlank(message = "Specialization name is required")
        @Size(
                max = 150,
                message = "Specialization name cannot exceed 150 characters"
        )
        String name,

        @Size(
                max = 1000,
                message = "Specialization description cannot exceed 1000 characters"
        )
        String description
) {
}
