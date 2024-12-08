package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadApplicationStatus;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="core_application_status")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreApplicationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreApplicationStatusId;

    @Column(length = 50,unique = true)
    private String name;

    @Column(length = 200)
    private String displayName;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "coreApplicationStatus",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadApplicationStatus> leadApplicationStatus = new ArrayList<>();

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
