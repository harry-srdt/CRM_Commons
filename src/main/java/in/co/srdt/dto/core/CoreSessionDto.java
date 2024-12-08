package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CoreSessionDto {

    private Long sessionId;
    @NotBlank(message = "Name can not be blank")
    private String name;
    private Status status;
    //private List<LeadCaptureDTO> leadCaptureDTOS = new ArrayList<>();

}
