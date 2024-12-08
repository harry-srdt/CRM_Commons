package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "core_academic_program_tution_fee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreAcademicProgramTutionFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academic_program_tution_fee_id")
    private Long academicProgramTutionFeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_program_id", nullable = false)
    private CoreAcademicProgram coreAcademicProgram;

    @Column(name = "fee_amount", precision = 9, scale = 2, nullable = false)
    private BigDecimal feeAmount;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

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
