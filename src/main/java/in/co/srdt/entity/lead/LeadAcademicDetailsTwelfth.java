package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.Core12thBoard;
import in.co.srdt.entity.coresetup.CoreTwelveMarkingScheme;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lead_academic_details_for_twelfth")
public class LeadAcademicDetailsTwelfth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicDetailsTwelfthId;

    @OneToOne
    @JoinColumn(name = "lead_capture_id", nullable = false)
    private LeadCapture leadCapture;

    @Column(length = 100)
    private String school;

    @ManyToOne
    @JoinColumn(name = "twelfth_board_id", nullable = false)
    private Core12thBoard twelveBoard;

    @ManyToOne
    @JoinColumn(name = "twelve_marking_scheme_id", nullable = false)
    private CoreTwelveMarkingScheme twelveMarkingScheme;

    private String twelveResultStatus;

    @Column(length = 5)
    private String twelveMarksOrGrade;

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
