package in.co.srdt.dto.lead;

import in.co.srdt.enums.ResultStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LeadAcademicDetailsUGDTO {

    @NotNull(message = "Academic Details ID cannot be null")
    private long academicDetailsUGId;

    @NotNull(message = "Lead Capture ID cannot be null")
    private Long leadCaptureId;

    @NotBlank(message = "Degree cannot be blank")
    @Size(max = 100, message = "Degree cannot exceed 100 characters")
    private String degree;

    @NotNull(message = "Result Status cannot be null")
    private ResultStatus resultStatus;

    private String marks;
}
