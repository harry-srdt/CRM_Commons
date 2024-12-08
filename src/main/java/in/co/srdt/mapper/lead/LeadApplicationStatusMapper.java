package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadApplicationStatusDTO;
import in.co.srdt.entity.lead.LeadApplicationStatus;
import in.co.srdt.exception.core.CoreApplicationStatusNotFoundException;
import in.co.srdt.exception.lead.LeadCaptureNotFoundException;
import in.co.srdt.repository.core.CoreApplicationStatusRepository;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadApplicationStatusMapper {

    private final CoreApplicationStatusRepository statusRepository;
    private final LeadCaptureRepository captureRepository;

    public LeadApplicationStatusDTO toDto(LeadApplicationStatus leadApplicationStatus) {
        if (leadApplicationStatus == null) {
            return null;
        }
        LeadApplicationStatusDTO dto = new LeadApplicationStatusDTO();
        dto.setLeadApplicationStatusId(leadApplicationStatus.getLeadApplicationStatusId());
        dto.setCoreApplicationStatusId(leadApplicationStatus.getLeadApplicationStatusId());
        dto.setLeadCaptureId( leadApplicationStatus.getLeadCapture() != null
                ? leadApplicationStatus.getLeadCapture().getLeadCaptureId()
                : null);
        return dto;
    }

    public LeadApplicationStatus toEntity(LeadApplicationStatusDTO leadApplicationStatusDto) {
        if (leadApplicationStatusDto == null)
            return null;

        LeadApplicationStatus entity = new LeadApplicationStatus();
        entity.setCoreApplicationStatus(statusRepository.
                findById(leadApplicationStatusDto.getCoreApplicationStatusId()).
                orElseThrow(()->
                        new CoreApplicationStatusNotFoundException("Core Application Status Not Found With This Id: " + leadApplicationStatusDto.getCoreApplicationStatusId())));

        entity.setLeadCapture(captureRepository.
                findById(leadApplicationStatusDto.getLeadCaptureId()).
                orElseThrow(()-> new LeadCaptureNotFoundException("Lead Capture Not Found With This Id  : " + leadApplicationStatusDto.getLeadCaptureId())));
        return entity;
    }
}
