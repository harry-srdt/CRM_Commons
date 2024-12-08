package in.co.srdt.dto.lead;

import lombok.Data;

@Data
public  class LeadActionsPerformedDTO {

    private Long leadActionsPerformedId;
    private Long leadCaptureId;
    private Long leadActionsId;
    private String actionTrackId;

}