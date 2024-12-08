package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadContactPhoneDTO;
import in.co.srdt.entity.lead.LeadContactPhone;
import in.co.srdt.exception.lead.LeadCaptureNotFoundException;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadContactPhoneMapper {

    private final LeadCaptureRepository captureRepository;

    public LeadContactPhoneDTO toDto(LeadContactPhone contactPhone){
        if (contactPhone==null)
            return null;
        LeadContactPhoneDTO dto  = new LeadContactPhoneDTO();
        dto.setLeadContactPhoneId(contactPhone.getLeadContactPhoneId());
        dto.setContactName(contactPhone.getContactName());
        dto.setContactNumber(contactPhone.getContactNumber());
        dto.setPrimary(contactPhone.isPrimary());
        dto.setContactRelation(contactPhone.getContactRelation());
        dto.setLeadCaptureId(contactPhone.getLeadCapture().getLeadCaptureId());
        return dto;
    }

    public LeadContactPhone toEntity(LeadContactPhoneDTO leadContactPhoneDTO){
        if (leadContactPhoneDTO==null)
            return null;
        LeadContactPhone entity = new LeadContactPhone();
        entity.setContactNumber(leadContactPhoneDTO.getContactNumber());
        entity.setContactName(leadContactPhoneDTO.getContactName());
        entity.setContactRelation(leadContactPhoneDTO.getContactRelation());
        entity.setPrimary(leadContactPhoneDTO.isPrimary());
        entity.setLeadCapture(captureRepository.
                findById(leadContactPhoneDTO.getLeadCaptureId()).
                orElseThrow(()-> new LeadCaptureNotFoundException("Lead Capture not found with this id : " + leadContactPhoneDTO.getLeadCaptureId())));
        return entity;
    }
}
