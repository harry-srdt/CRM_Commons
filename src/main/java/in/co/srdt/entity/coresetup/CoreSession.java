package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "core_session")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @Column(length = 50, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "coreSession",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadCapture> leadCaptures = new ArrayList<>();

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
