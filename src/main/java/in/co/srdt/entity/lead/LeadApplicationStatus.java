package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.CoreApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lead_application_status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeadApplicationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadApplicationStatusId;

    @ManyToOne
    @JoinColumn(name = "coe_application_status_id")
    private CoreApplicationStatus coreApplicationStatus;

    @ManyToOne
    @JoinColumn(name = "lead_capture_id")
    private LeadCapture leadCapture;

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
