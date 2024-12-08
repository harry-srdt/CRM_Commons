package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.CoreLeadStage;
import in.co.srdt.entity.coresetup.CoreLeadSubStage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lead_stage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadStageId;

    @ManyToMany(mappedBy = "leadStages")
    private List<LeadCapture> leadCaptures = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "core_lead_stage_id")
    private CoreLeadStage coreLeadStage;

    @ManyToOne
    @JoinColumn(name = "core_lead_sub_stage_id")
    private CoreLeadSubStage coreLeadSubStage;

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
