package in.co.srdt.leadactions;

import in.co.srdt.entity.coresetup.CoreLeadActions;
import in.co.srdt.entity.lead.LeadActionsPerformed;
import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.exception.lead.ResourceNotFoundException;
import in.co.srdt.repository.core.CoreLeadActionsRepository;
import in.co.srdt.repository.lead.LeadActionsPerformedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class InsertDataIntoLeadActionsPerformed{

    private final CoreLeadActionsRepository actionsRepository;
    private final LeadActionsPerformedRepository actionsPerformedRepository;

    @Transactional
    public void insertActionsInLeadActionsPerformed(LeadCapture leadCapture,String uuid ,String coreLeadAction, String currentUser) {

        LeadActionsPerformed actionsPerformed = new LeadActionsPerformed();
        actionsPerformed.setLeadCapture(leadCapture);
        actionsPerformed.setCreatedBy(currentUser);
        actionsPerformed.setUpdatedBy(currentUser);

        CoreLeadActions coreLeadActions = actionsRepository
                .findByName(coreLeadAction)
                .orElseThrow(()-> new ResourceNotFoundException("Lead Actions Not Found With This Name : " + coreLeadAction));
        actionsPerformed.setCoreLeadActions(coreLeadActions);
        actionsPerformed.setActionTrackId(uuid);

        actionsPerformedRepository.save(actionsPerformed);
    }
}
