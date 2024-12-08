package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.enums.ResultStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lead_academic_details_diploma")
public class LeadAcademicDetailsDiploma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicDetailsDiplomaId;

    @OneToOne
    @JoinColumn(name = "lead_capture_id", nullable = false)
    private LeadCapture leadCapture;

    @Column(length = 100)
    private String school;

    @Column(length = 100)
    private String diplomaBoard;

    @Enumerated(EnumType.STRING)
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
