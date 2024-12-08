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
@Table(name = "core_lead_sub_stage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreLeadSubStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadSubStageId;
    private String name;
    private String displayName;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "core_lead_stage_id")
    private CoreLeadStage coreLeadStage;

    @OneToMany(mappedBy = "coreLeadSubStage",cascade = CascadeType.ALL,orphanRemoval = true)
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
