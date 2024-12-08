package in.co.srdt.dto.lead;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LeadContactPhoneDTO {

    private Long leadContactPhoneId;
    @NotNull
    private String contactName;
    @NotNull
    private String contactRelation;
    @NotNull
    private String contactNumber;
    private boolean isPrimary;
    private Long leadCaptureId;
}
