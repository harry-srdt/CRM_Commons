package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "core_scholarship_scheme")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreScholarshipScheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scholarshipSchemeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scholarship_category_id", nullable = false)
    private CoreScholarshipCategory scholarshipCategory;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 200)
    private String displayName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "scholarshipScheme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CoreScholarshipSlab> scholarshipSlabs;

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
