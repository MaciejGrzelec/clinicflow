package pl.clinicflow.clinic_service.common;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorProvider implements AuditorAware<String> {

    private static final String SYSTEM_USER = "system";

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SYSTEM_USER);
    }
}
