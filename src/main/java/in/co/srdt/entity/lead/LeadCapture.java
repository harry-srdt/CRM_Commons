package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.crmcommons.entity.coresetup.*;
import in.co.srdt.entity.coresetup.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lead_capture")
@Data
@AllArgsConstructor
@NoArgsConstructor
/*@NamedQueries({
        @NamedQuery(
                name = "LeadCapture.findByFilters",
                query = "SELECT lc FROM LeadCapture lc WHERE " +
                        "(:leadStageId IS NULL OR lc.leadStage.id = :leadStageId) " +
                        "AND (:leadSourceId IS NULL OR lc.leadSource.id = :leadSourceId) " +
                        "AND ((" +
                        "(:dateFilterType IS NULL) OR " +
                        "((:startDate IS NOT NULL AND :endDate IS NOT NULL AND " +
                        "(CASE WHEN :dateFilterType = 'created_at' THEN lc.createdAt " +
                        "WHEN :dateFilterType = 'updated_at' THEN lc.updatedAt END) " +
                        "BETWEEN :startDate AND :endDate) OR " +
                        "(:customStartDate IS NOT NULL AND :customEndDate IS NOT NULL AND " +
                        "(CASE WHEN :dateFilterType = 'created_at' THEN lc.createdAt " +
                        "WHEN :dateFilterType = 'updated_at' THEN lc.updatedAt END) " +
                        "BETWEEN :customStartDate AND :customEndDate)))" +
                        ")"
        )
})*/

@NamedQueries({
        @NamedQuery(
                name = "LeadCapture.findByFilters",
                query = "SELECT lc FROM LeadCapture lc " +
                        "LEFT JOIN lc.leadStages ls " +
                        "WHERE (:leadStageId IS NULL OR ls.leadStageId = :leadStageId) " +
                        "AND (:leadSourceId IS NULL OR lc.leadSource.id = :leadSourceId) " +
                        "AND ((" +
                        "(:dateFilterType IS NULL) OR " +
                        "((:startDate IS NOT NULL AND :endDate IS NOT NULL AND " +
                        "(CASE WHEN :dateFilterType = 'created_at' THEN lc.createdAt " +
                        "WHEN :dateFilterType = 'updated_at' THEN lc.updatedAt END) " +
                        "BETWEEN :startDate AND :endDate) OR " +
                        "(:customStartDate IS NOT NULL AND :customEndDate IS NOT NULL AND " +
                        "(CASE WHEN :dateFilterType = 'created_at' THEN lc.createdAt " +
                        "WHEN :dateFilterType = 'updated_at' THEN lc.updatedAt END) " +
                        "BETWEEN :customStartDate AND :customEndDate)))" +
                        ")"
        )
})

public class LeadCapture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadCaptureId;

    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String email;
    @Column(length = 11)
    private String phone;

    @OneToMany(mappedBy = "leadCapture", cascade = CascadeType.ALL)
    private List<LeadScheduledTask> scheduledTasks;

    @OneToMany(mappedBy = "leadCapture",cascade = CascadeType.ALL)
    private List<LeadNotes> leadNotes;

    @ManyToOne
    @JoinColumn(name = "core_state_id")
    private CoreState coreState;

    @ManyToOne
    @JoinColumn(name = "core_city_id")
    private CoreCity coreCity;

    @ManyToOne
    @JoinColumn(name = "core_academic_career_id")
    private CoreAcademicCareer academicCareer;

    @ManyToOne
    @JoinColumn(name="core_academic_program_id")
    private CoreAcademicProgram academicProgram;

    @ManyToOne
    @JoinColumn(name="core_lead_source_id")
    private CoreLeadSource leadSource;

    @OneToMany(mappedBy = "leadCapture",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadContactPhone> contactPhones = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "lead_stage_capture_mapping",
            joinColumns = {@JoinColumn(name = "lead_capture_id")},
            inverseJoinColumns = {@JoinColumn(name = "lead_stage_id")}
    )
    private List<LeadStage> leadStages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "core_session_id")
    private CoreSession coreSession;

    @OneToMany(mappedBy = "leadCapture",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadApplicationStatus> leadApplicationStatuses = new ArrayList<>();

    @OneToMany(mappedBy = "leadCapture",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadAddressDetails> leadAddressDetails = new ArrayList<>();

    @OneToOne(mappedBy = "leadCapture", cascade = CascadeType.ALL)
    private LeadAdditionalDetails leadAdditionalDetails;

    @OneToOne(mappedBy = "leadCapture", cascade = CascadeType.ALL)
    private LeadAcademicDetailsForTenth academicDetails;

    @OneToMany(mappedBy = "leadCapture",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadActionsPerformed> leadActionsPerformeds = new ArrayList<>();

    @OneToOne(mappedBy = "leadCapture",cascade = CascadeType.ALL,orphanRemoval = true)
    private LeadAcademicDetailsTwelfth leadAcademicDetailsTwelfths;

    @OneToOne(mappedBy = "leadCapture",cascade = CascadeType.ALL,orphanRemoval = true)
    private LeadAcademicDetailsDiploma leadAcademicDetailsDiplomas;

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
