package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.enums.ResultStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lead_academic_details_UG")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadAcademicDetailsUG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long academicDetailsUGId;
    @OneToOne
    @JoinColumn(name = "lead_capture_id")
    private LeadCapture leadCapture;
    private String degree;
    private ResultStatus resultStatus;
    @Column(length = 5)
    private String marks;

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
