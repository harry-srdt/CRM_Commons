package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadStage;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "core_lead_stage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreLeadStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadStageId;
    @Column(nullable = false)
    private String name;
    private String displayName;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "coreLeadStage",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CoreLeadSubStage> leadSubStage = new ArrayList<>();


    @OneToMany(mappedBy = "coreLeadStage",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadStage> leadStages = new ArrayList<>();

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
