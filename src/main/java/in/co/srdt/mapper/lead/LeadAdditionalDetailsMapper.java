package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadAdditionalDetailsDTO;
import in.co.srdt.entity.lead.LeadAdditionalDetails;
import in.co.srdt.exception.core.CoreCategoryNotFoundException;
import in.co.srdt.repository.core.CoreAdmitTypeRepository;
import in.co.srdt.repository.core.CoreCategoryRepository;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadAdditionalDetailsMapper {

    private final CoreCategoryRepository categoryRepository;
    private final CoreAdmitTypeRepository admitTypeRepository;
    private final LeadCaptureRepository captureRepository;

    public LeadAdditionalDetailsDTO toDto(LeadAdditionalDetails leadAdditionalDetails){
        if (leadAdditionalDetails==null)
            return null;
        LeadAdditionalDetailsDTO dto = new LeadAdditionalDetailsDTO();
        dto.setLeadAdditionalDetailId(leadAdditionalDetails.getLeadAdditionalDetailId());
        dto.setCategoryId(leadAdditionalDetails.getCoreCategory()!=null?
                leadAdditionalDetails.getCoreCategory().getCategoryId():0);
        dto.setAdmitTypeId(leadAdditionalDetails.getCoreAdmitType()!=null
                ?leadAdditionalDetails.getCoreAdmitType().getAdmitTypeId():0);
        dto.setLeadCaptureId(leadAdditionalDetails.getLeadCapture()!=null
                ?leadAdditionalDetails.getLeadCapture().getLeadCaptureId():0);
        dto.setGender(leadAdditionalDetails.getGender());
        dto.setParentGuardianName(leadAdditionalDetails.getParentGuardianName());
        dto.setParentGuardianContact(leadAdditionalDetails.getParentGuardianContact());
        dto.setCategoryName(leadAdditionalDetails.getCoreCategory().getName());
        dto.setAdmitTypeName(leadAdditionalDetails.getCoreAdmitType().getName());

        return dto;
    }

    public LeadAdditionalDetails toEntity(LeadAdditionalDetailsDTO detailsDTO){
        if (detailsDTO==null)
            return null;
        LeadAdditionalDetails entity = new LeadAdditionalDetails();
        entity.setCoreCategory(categoryRepository
                .findById(detailsDTO.getCategoryId())
                .orElseThrow(() ->
                        new CoreCategoryNotFoundException("Category not found with this id: " + detailsDTO.getCategoryId())));
        entity.setCoreAdmitType(admitTypeRepository
                .findById(detailsDTO.getAdmitTypeId())
                .orElseThrow(() ->
                        new CoreCategoryNotFoundException("Admit not found with this id: " + detailsDTO.getAdmitTypeId())));
        entity.setLeadCapture(captureRepository
                .findById(detailsDTO.getLeadCaptureId())
                .orElseThrow(() ->
                        new CoreCategoryNotFoundException("Lead Capture not found with this id: " + detailsDTO.getLeadCaptureId())));
        entity.setGender(detailsDTO.getGender());
        entity.setParentGuardianName(detailsDTO.getParentGuardianName());
        entity.setParentGuardianContact(detailsDTO.getParentGuardianContact());
        return entity;
    }

}
