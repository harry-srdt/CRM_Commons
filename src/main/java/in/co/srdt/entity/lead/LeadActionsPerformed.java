package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.CoreLeadActions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lead_actions_performed")
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadActionsPerformed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadActionsPerformedId;

    @ManyToOne
    @JoinColumn(name = "lead_capture_id", nullable = false)
    private LeadCapture leadCapture;

    @ManyToOne
    @JoinColumn(name = "core_lead_actions_id", nullable = false)
    private CoreLeadActions coreLeadActions;

    private String actionTrackId;

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

    public Long getLeadActionsPerformedId() {
        return leadActionsPerformedId;
    }

    public void setLeadActionsPerformedId(Long leadActionsPerformedId) {
        this.leadActionsPerformedId = leadActionsPerformedId;
    }

    public LeadCapture getLeadCapture() {
        return leadCapture;
    }

    public void setLeadCapture(LeadCapture leadCapture) {
        this.leadCapture = leadCapture;
    }

    public CoreLeadActions getCoreLeadActions() {
        return coreLeadActions;
    }

    public void setCoreLeadActions(CoreLeadActions coreLeadActions) {
        this.coreLeadActions = coreLeadActions;
    }

    public String getActionTrackId() {
        return actionTrackId;
    }

    public void setActionTrackId(String actionTrackId) {
        this.actionTrackId = actionTrackId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
