package in.co.srdt.dto.lead;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LeadAcademicDetailsForTenthDTO {

    private Long academicDetailsTenthId;
    private Long leadCaptureId;
    @NotNull(message = "name is required")
    private String school;
    private Long coreTenthBoardId;
    private Long coreTenthMarkingSchemeId;
    @NotNull
    private String tenthMarksOrGrade;
    private String tenthBoardName;
    private String tenthMarkingSchemeName;


}
