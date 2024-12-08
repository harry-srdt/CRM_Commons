package in.co.srdt.dto.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreAcademicProgramYearlyFeeDto {

    private Long academicProgramYearlyFeeId;
    private Long academicProgramId;
    private BigDecimal feeAmount;
    private LocalDate effectiveDate;
    private String coreAcademicCareerName;
    private String coreAcademicProgramName;

}
