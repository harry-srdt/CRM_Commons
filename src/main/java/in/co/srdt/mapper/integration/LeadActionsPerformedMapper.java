package in.co.srdt.mapper.integration;

import in.co.srdt.dto.lead.LeadActionsPerformedDTO;
import in.co.srdt.entity.lead.LeadActionsPerformed;
import in.co.srdt.exception.integration.LeadActionsPerformedNotFoundException;
import in.co.srdt.exception.lead.LeadCaptureNotFoundException;
import in.co.srdt.repository.core.CoreLeadActionsRepository;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadActionsPerformedMapper {

    private final CoreLeadActionsRepository actionsRepository;
    private final LeadCaptureRepository captureRepository;

    public LeadActionsPerformedDTO toDto(LeadActionsPerformed actionsPerformed){
        if (actionsPerformed==null)
            return null;

        LeadActionsPerformedDTO dto = new LeadActionsPerformedDTO();
        dto.setLeadActionsPerformedId(actionsPerformed.getLeadActionsPerformedId());
        dto.setLeadActionsId(actionsPerformed.getCoreLeadActions()!=null?actionsPerformed.getCoreLeadActions().getCoreLeadActionsId():0);
        dto.setLeadCaptureId(actionsPerformed.getLeadCapture()!=null?actionsPerformed.getLeadCapture().getLeadCaptureId():0);
        dto.setActionTrackId(actionsPerformed.getActionTrackId());
        return dto;
    }

    public LeadActionsPerformed toEntity(LeadActionsPerformedDTO actionsPerformedDTO){
        if (actionsPerformedDTO==null)
            return null;

        LeadActionsPerformed entity = new LeadActionsPerformed();
        entity.setLeadActionsPerformedId(actionsPerformedDTO.getLeadActionsPerformedId());
        entity.setCoreLeadActions(actionsRepository
                .findById(actionsPerformedDTO.getLeadActionsId())
                .orElseThrow(()->new LeadActionsPerformedNotFoundException("Lead Action Performed Not found with this id : " + actionsPerformedDTO.getLeadActionsId())));
        entity.setLeadCapture(captureRepository
                .findById(actionsPerformedDTO.getLeadCaptureId())
                .orElseThrow(()->new LeadCaptureNotFoundException("Lead Capture Not Found with this id :" + actionsPerformedDTO.getLeadCaptureId())));
        entity.setActionTrackId(entity.getActionTrackId());
        return entity;
    }

}
