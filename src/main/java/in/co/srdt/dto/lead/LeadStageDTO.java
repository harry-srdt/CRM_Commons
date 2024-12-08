package in.co.srdt.dto.lead;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LeadStageDTO {

    private Long leadStageId;
    private Long coreLeadStageId;
    private Long coreLeadSubStageId;
    private List<Long> leadCaptureIds = new ArrayList<>();
}
