package in.co.srdt.entity.coresetup;


import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadAdditionalDetails;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "core_admit_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreAdmitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admitTypeId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "coreAdmitType",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadAdditionalDetails> leadAdditionalDetails = new ArrayList<>();

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
