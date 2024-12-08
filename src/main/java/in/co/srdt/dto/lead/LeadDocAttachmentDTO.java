package in.co.srdt.dto.lead;

import lombok.Data;

@Data
public class LeadDocAttachmentDTO {

    private Long leadDocAttachmentId;
    private Long coreDocAttachmentTypeId;
    private String name;
    private Long leadCaptureId;
}
