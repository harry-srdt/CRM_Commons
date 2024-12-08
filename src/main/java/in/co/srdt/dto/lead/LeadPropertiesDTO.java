package in.co.srdt.dto.lead;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LeadPropertiesDTO {

    private Long leadCaptureId;
    private String leadName;
    private String phone;
    private String email;
    private String careerName;
    private String programName;
    private String cityName;
    private String stateName;
    private String sourceName;
    private String sessionName;
    private String leadStageName;
    private Long salesrepId;
    private String salesrepName;
}
