package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "core_academic_program")
public class CoreAcademicProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicProgramId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_career_id", nullable = false)
    private CoreAcademicCareer coreAcademicCareer;

    @OneToMany(mappedBy = "coreAcademicProgram", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CoreAcademicProgramYearlyFee> coreAcademicProgramYearlyFee = new ArrayList<>();

    @OneToMany(mappedBy = "coreAcademicProgram", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CoreAcademicProgramTutionFee> coreAcademicProgramTutionFee = new ArrayList<>();

    @OneToMany(mappedBy = "academicProgram", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeadCapture> leadCaptures = new ArrayList<>();

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

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
        this.createdAt = LocalDateTime.now(); // Set the current timestamp when the entity is created
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now(); // Set the current timestamp when the entity is updated
    }
}
