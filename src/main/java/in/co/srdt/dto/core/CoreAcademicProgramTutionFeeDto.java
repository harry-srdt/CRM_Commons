package in.co.srdt.dto.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreAcademicProgramTutionFeeDto {

    private Long academicProgramTuitionFeeId;
    private Long academicProgramId;
    private String academicCareerName;
    private String academicProgramName;
    private BigDecimal feeAmount;
    private LocalDate effectiveDate;
}
