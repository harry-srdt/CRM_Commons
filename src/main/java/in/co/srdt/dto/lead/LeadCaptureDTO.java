package in.co.srdt.dto.lead;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class LeadCaptureDTO {

    private Long leadCaptureId;
    @NotBlank(message = "Name can not be blank")
    private String name;
    @NotBlank(message = "Email can not be blank")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotBlank(message = "Phone can not be blank")
    private String phone;
    private Long currentCoreStateId;
    private Long currentCoreCityId;
    private Long academicCareerId;
    private String careerDescription;
    private Long academicProgramId;
    private String programDescription;
    private Long leadSourceId;
    private String leadDescription;
    private Long coreSessionId;
    private String leadStageName;
    private LocalDateTime modifiedOn;
    private String stateName;
    private String cityName;
    private String academicCareerName;
    private String academicProgramName;
    private String leadSourceName;
    private String sessionName;
    private List<LeadStageDTO> leadStages = new ArrayList<>();

}

