package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.Core10thBoard;
import in.co.srdt.entity.coresetup.Core10thMarkingScheme;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lead_academic_details_for_tenth")
public class LeadAcademicDetailsForTenth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicDetailsTenthId;

    @OneToOne
    @JoinColumn(name = "lead_capture_id")
    private LeadCapture leadCapture;

    @Column(length = 100)
    private String school;

    @ManyToOne
    @JoinColumn(name = "tenth_board_id")
    private Core10thBoard coreTenthBoard;

    @ManyToOne
    @JoinColumn(name = "tenth_markingscheme_id")
    private Core10thMarkingScheme coreTenthMarkingScheme;

    @Column(length = 5)
    private String tenthMarksOrGrade;

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
