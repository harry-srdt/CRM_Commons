package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.CoreSalesRepDetails;
import in.co.srdt.entity.coresetup.CoreTaskType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "lead_scheduled_task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadScheduledTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadScheduledTaskId;

    @ManyToOne
    @JoinColumn(name = "core_task_type_id")
    private CoreTaskType coreTaskType;

    @ManyToOne
    @JoinColumn(name = "salesrp_details_id")
    private CoreSalesRepDetails salesrpDetails;

    @ManyToOne
    @JoinColumn(name = "lead_capture_id", referencedColumnName = "leadCaptureId")
    private LeadCapture leadCapture;

    @Column(length = 50, nullable = false)
    private String subject;

    private boolean isCompleted = false;

    private LocalDate scheduledDate;

    private LocalTime scheduledTime;

    @Column(length = 100)
    private String location;

    @Lob
    private String taskDetails;

    private Long organizer;

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    @Column(length = 20)
    private String createdBy;

    @JsonIgnore
    @Column(length = 20)
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
