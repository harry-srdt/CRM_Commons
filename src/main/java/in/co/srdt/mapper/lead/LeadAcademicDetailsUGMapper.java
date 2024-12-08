package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadAcademicDetailsUGDTO;
import in.co.srdt.entity.lead.LeadAcademicDetailsUG;
import in.co.srdt.exception.lead.ResourceNotFoundException;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadAcademicDetailsUGMapper {

    private final LeadCaptureRepository captureRepository;

    public LeadAcademicDetailsUGDTO toDto(LeadAcademicDetailsUG detailsUG){
        if (detailsUG==null)
            return null;
        LeadAcademicDetailsUGDTO dto = new LeadAcademicDetailsUGDTO();
        dto.setAcademicDetailsUGId(detailsUG.getAcademicDetailsUGId());
        dto.setLeadCaptureId(detailsUG.getLeadCapture()!=null?detailsUG.getLeadCapture().getLeadCaptureId():null);
        dto.setDegree(detailsUG.getDegree());
        dto.setMarks(detailsUG.getMarks());
        dto.setResultStatus(detailsUG.getResultStatus());
        return dto;
    }

    public LeadAcademicDetailsUG toEntity(LeadAcademicDetailsUGDTO detailsUGDTO){
        if (detailsUGDTO==null)
            return null;
        LeadAcademicDetailsUG entity = new LeadAcademicDetailsUG();
        entity.setAcademicDetailsUGId(detailsUGDTO.getAcademicDetailsUGId());
        entity.setDegree(detailsUGDTO.getDegree());
        entity.setMarks(detailsUGDTO.getMarks());
        entity.setResultStatus(detailsUGDTO.getResultStatus());
        entity.setLeadCapture(captureRepository
                .findById(detailsUGDTO.getLeadCaptureId())
                .orElseThrow(()-> new ResourceNotFoundException("Lead Capture Not Found With This Id : " + detailsUGDTO.getLeadCaptureId() )));
        return entity;
    }
}
