package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadAddressDetails;
import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "core_city")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreCityId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "core_state_id", nullable = false)
    private CoreState coreState;

    @OneToMany(mappedBy = "coreCity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeadCapture> leadCaptures = new ArrayList<>();

    @OneToMany(mappedBy = "coreCity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadAddressDetails> leadAddressDetails = new ArrayList<>();

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
