package pl.clinicflow.clinic_service.specialization;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
@Slf4j
public class SpecializationDataInitializer implements ApplicationRunner {

    private final SpecializationRepository specializationRepository;

    public SpecializationDataInitializer(final SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    @Transactional
    public void run(final ApplicationArguments args) {
        createIfMissing(
                "DENTISTRY",
                "Dentistry",
                "Diagnosis and treatment of diseases affecting the teeth and oral cavity");

        createIfMissing(
                "CARDIOLOGY",
                "Cardiology",
                "Diagnosis and treatment of cardiovascular diseases");

        createIfMissing(
                "DERMATOLOGY",
                "Dermatology",
                "Diagnosis and treatment of skin diseases");

        createIfMissing(
                "PHYSIOTHERAPY",
                "Physiotherapy",
                "Functional assessment, treatment and rehabilitation of patients");

        createIfMissing(
                "OPHTHALMOLOGY",
                "Ophthalmology",
                "Diagnosis and treatment of eye diseases");
    }

    private void createIfMissing(
            final String code,
            final String name,
            final String description) {
        if (specializationRepository.existsByCodeIgnoreCase(code)) {
            log.debug("Specialization with code '{}' already exists", code);
            return;
        }

        final var specialization = new Specialization(code, name, description);

        specializationRepository.save(specialization);

        log.info("Created initial specialization with code '{}'", code);
    }
}
