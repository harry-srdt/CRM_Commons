package in.co.srdt.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.dto.lead.LeadDocAttachmentDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoreDocAttachmentTypeDto {

    private Long coreDocAttachmentTypeId;
    @JsonIgnore
    private List<LeadDocAttachmentDTO> leadDocAttachmentDTOS;
    private String name;
}
