package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadAcademicDetailsForTenth;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "core_10th_marking_scheme")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Core10thMarkingScheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "core_marking_scheme_id")
    private Long Core10thMarkingSchemeId;

    @Column(length = 50)
    private String name;

    @Column(length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "coreTenthMarkingScheme",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadAcademicDetailsForTenth> leadAcademicDetailsForTenths = new ArrayList<>();

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    private String createdBy;

    @JsonIgnore
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
