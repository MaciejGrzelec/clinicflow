package pl.clinicflow.clinic_service.specialization;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.clinicflow.clinic_service.common.ResourceNotFoundException;

@Service
public class SpecializationService {

    private final SpecializationRepository specializationRepository;
    private final SpecializationMapper specializationMapper;

    public SpecializationService(
            final SpecializationRepository specializationRepository,
            final SpecializationMapper specializationMapper
    ) {
        this.specializationRepository = specializationRepository;
        this.specializationMapper = specializationMapper;
    }

    @Transactional
    public SpecializationResponse create(
            final CreateSpecializationRequest request
    ) {
        final var specialization = new Specialization(
                request.code(),
                request.name(),
                request.description()
        );

        final var savedSpecialization =
                specializationRepository.save(specialization);

        return specializationMapper.toResponse(savedSpecialization);
    }

    @Transactional(readOnly = true)
    public SpecializationResponse getById(final UUID id) {
        final var specialization = findById(id);

        return specializationMapper.toResponse(specialization);
    }

    @Transactional(readOnly = true)
    public List<SpecializationResponse> getAll(
            final boolean activeOnly
    ) {
        final List<Specialization> specializations;

        if (activeOnly) {
            specializations = specializationRepository
                    .findAllByActiveTrueOrderByNameAsc();
        } else {
            specializations = specializationRepository
                    .findAllByOrderByNameAsc();
        }

        return specializations.stream()
                .map(specializationMapper::toResponse)
                .toList();
    }

    @Transactional
    public SpecializationResponse update(
            final UUID id,
            final CreateSpecializationRequest request
    ) {
        final var specialization = findById(id);

        specialization.update(
                request.code(),
                request.name(),
                request.description()
        );

        return specializationMapper.toResponse(specialization);
    }

    @Transactional
    public SpecializationResponse activate(final UUID id) {
        final var specialization = findById(id);

        specialization.activate();

        return specializationMapper.toResponse(specialization);
    }

    @Transactional
    public SpecializationResponse deactivate(final UUID id) {
        final var specialization = findById(id);

        specialization.deactivate();

        return specializationMapper.toResponse(specialization);
    }

    private Specialization findById(final UUID id) {
        return specializationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Specialization with id '%s' was not found"
                                .formatted(id)
                ));
    }
}
