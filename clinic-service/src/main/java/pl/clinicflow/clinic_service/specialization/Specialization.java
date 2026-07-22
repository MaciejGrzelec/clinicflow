package pl.clinicflow.clinic_service.specialization;

import java.util.Locale;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.clinicflow.clinic_service.common.BaseEntity;


@Entity
@Table(name = "specializations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Specialization extends BaseEntity {

    @Column(nullable = false, length = 50)
    private String code;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private boolean active;

    public Specialization(
            final String code,
            final String name,
            final String description) {
        super(UUID.randomUUID());

        this.code = normalizeCode(code);
        this.name = normalizeName(name);
        this.description = normalizeDescription(description);
        this.active = true;
    }

    public void update(
            final String code,
            final String name,
            final String description
    ) {
        this.code = normalizeCode(code);
        this.name = normalizeName(name);
        this.description = normalizeDescription(description);
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    private static String normalizeCode(final String code) {
        return code.strip().toUpperCase(Locale.ROOT);
    }

    private static String normalizeName(final String name) {
        return name.strip();
    }

    private static String normalizeDescription(final String description) {
        return description == null || description.isBlank()
                ? null
                : description.strip();
    }
}
