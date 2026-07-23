package pl.clinicflow.clinic_service.specialization;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository
        extends JpaRepository<Specialization, UUID> {

    boolean existsByCodeIgnoreCase(String code);

    List<Specialization> findAllByOrderByNameAsc();

    List<Specialization> findAllByActiveTrueOrderByNameAsc();
}
