package in.co.srdt.dto.lead;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LeadApplicationStatusDTO {

    private Long leadApplicationStatusId;

    @NotNull(message = "Core Application Status is required")
    private Long coreApplicationStatusId;

    @NotNull(message = "Lead Capture is required")
    private Long leadCaptureId;

}
