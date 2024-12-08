package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadScheduledTask;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "core_task_type")
public class CoreTaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreTaskTypeId;

    @OneToMany(mappedBy = "coreTaskType")
    private List<LeadScheduledTask> scheduledTask;

    @ManyToOne
    @JoinColumn(name = "core_task_category_id")
    private CoreTaskCategory category;

    @Column(length = 100, nullable = false)
    private String name;

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
