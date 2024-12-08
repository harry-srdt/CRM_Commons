package in.co.srdt.dto.lead;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class LeadScheduledTaskDTO {

    private Long leadScheduledTaskId;

    private Long coreTaskTypeId;

    private String coreTaskTypeName;

    private Long salesrpDetailsId;

    private String salesrpDetailsName;

    private Long leadCaptureId;

    private String leadCaptureName;

    private String subject;

    private boolean isCompleted;

    private LocalDate scheduledDate;

    private LocalTime scheduledTime;

    private String location;

    private String taskDetails;

    private Long organizer;

    private LocalDateTime createdAt;
}
