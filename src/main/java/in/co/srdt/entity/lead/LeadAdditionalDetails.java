package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.CoreAdmitType;
import in.co.srdt.entity.coresetup.CoreCategory;
import in.co.srdt.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lead_additional_details")
public class LeadAdditionalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadAdditionalDetailId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CoreCategory coreCategory;

    @ManyToOne
    @JoinColumn(name = "admit_type_id")
    private CoreAdmitType coreAdmitType;

    @OneToOne
    @JoinColumn(name = "lead_capture_id")
    private LeadCapture leadCapture;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 100)
    private String parentGuardianName;

    @Column(length = 11)
    private String parentGuardianContact;

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
