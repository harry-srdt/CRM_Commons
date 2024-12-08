package in.co.srdt.dto.lead;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeadNotesDTO {

    private Long leadNotesId;
    private Long leadCaptureId;
    private String note;
    private LeadDocAttachmentDTO leadDocAttachmentDTO;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
