package in.co.srdt.dto.lead;

import in.co.srdt.enums.Gender;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LeadAdditionalDetailsDTO {

    private Long leadAdditionalDetailId;
    private Long categoryId;
    private String categoryName;
    private Long admitTypeId;
    private String admitTypeName;
    private Long leadCaptureId;
    @NotNull
    private Gender gender;
    @NotNull
    @Size(max = 100, message = "Guardian Name cannot exceed 100 characters")
    private String parentGuardianName;
    @NotNull
    private String parentGuardianContact;

}
