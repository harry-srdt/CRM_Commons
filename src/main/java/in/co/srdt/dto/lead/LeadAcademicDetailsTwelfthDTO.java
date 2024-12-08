package in.co.srdt.dto.lead;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadAcademicDetailsTwelfthDTO {

    private Long academicDetailsTwelfthId;

    @NotNull(message = "Lead Capture ID cannot be null")
    private Long leadCaptureId;

    @NotBlank(message = "School name is required")
    @Size(max = 100, message = "School name cannot exceed 100 characters")
    private String school;

    @NotNull(message = "12th Board ID cannot be null")
    private Long twelveBoardId;

    @NotNull(message = "Marking Scheme ID cannot be null")
    private Long twelveMarkingSchemeId;

    @Size(max = 5, message = "Marks or Grade cannot exceed 5 characters")
    private String twelveMarksOrGrade;

    private String twelveResultStatus;

    private String twelveBoardName;

    private String twelveMarkingSchemeName;
}
