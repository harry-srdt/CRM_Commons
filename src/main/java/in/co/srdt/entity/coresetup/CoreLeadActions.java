package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadActionsPerformed;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "core_lead_actions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreLeadActions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreLeadActionsId;

    @Column(length = 50)
    private String name;

    @Column(length = 100)
    private String displayName;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    private String iconName;

    @OneToMany(mappedBy = "coreLeadActions",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadActionsPerformed> leadActionsPerformeds = new ArrayList<>();

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
