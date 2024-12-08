package in.co.srdt.dto.integration;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IVR_OutboundPlaceCallDTO {

    private Long ivrOutboundPlaceCallId;
    private String message;
    private String status;
    private String callId;
    private String refId;
    private LocalDateTime createdAt;
    private Long leadCaptureId;
}
