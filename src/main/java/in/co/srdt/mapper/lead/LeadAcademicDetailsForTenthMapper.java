package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadAcademicDetailsForTenthDTO;
import in.co.srdt.entity.lead.LeadAcademicDetailsForTenth;
import in.co.srdt.exception.core.Core10thBoardNotFoundException;
import in.co.srdt.exception.core.Core10thMarkingSchemeNotFoundException;
import in.co.srdt.exception.lead.LeadCaptureNotFoundException;
import in.co.srdt.repository.core.Core10thBoardRepository;
import in.co.srdt.repository.core.Core10thMarkingSchemeRepository;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadAcademicDetailsForTenthMapper {

    private final Core10thBoardRepository tenthBoardRepository;
    private final LeadCaptureRepository captureRepository;
    private final Core10thMarkingSchemeRepository schemeRepository;

    public LeadAcademicDetailsForTenthDTO toDto(LeadAcademicDetailsForTenth detailsForTenth){
        if (detailsForTenth==null)
            return null;
        LeadAcademicDetailsForTenthDTO dto = new LeadAcademicDetailsForTenthDTO();
        dto.setAcademicDetailsTenthId(detailsForTenth.getAcademicDetailsTenthId());
        dto.setLeadCaptureId(detailsForTenth.getLeadCapture()!=null?detailsForTenth.getLeadCapture().getLeadCaptureId():0);
        dto.setSchool(detailsForTenth.getSchool());
        dto.setCoreTenthBoardId(detailsForTenth.getCoreTenthBoard()!=null?detailsForTenth.getCoreTenthBoard().getCore10BoardId():0);
        dto.setTenthMarksOrGrade(detailsForTenth.getTenthMarksOrGrade());
        dto.setCoreTenthMarkingSchemeId(detailsForTenth.getCoreTenthMarkingScheme()!=null?detailsForTenth.getCoreTenthMarkingScheme().getCore10thMarkingSchemeId():0);
        dto.setTenthBoardName(detailsForTenth.getCoreTenthBoard().getName());
        dto.setTenthMarkingSchemeName(detailsForTenth.getCoreTenthMarkingScheme().getName());
        return dto;
    }

    public LeadAcademicDetailsForTenth toEntity(LeadAcademicDetailsForTenthDTO detailsForTenthDTO){
        if (detailsForTenthDTO==null)
            return null;
        LeadAcademicDetailsForTenth entity = new LeadAcademicDetailsForTenth();
        entity.setSchool(detailsForTenthDTO.getSchool());
        entity.setCoreTenthBoard(tenthBoardRepository
                .findById(detailsForTenthDTO.getCoreTenthBoardId())
                .orElseThrow(()->new Core10thBoardNotFoundException("10th board not found with this id : " + detailsForTenthDTO.getCoreTenthBoardId())));
        entity.setLeadCapture(captureRepository
                .findById(detailsForTenthDTO.getLeadCaptureId())
                .orElseThrow(()-> new LeadCaptureNotFoundException("Lead Capture Not found with this id : " + detailsForTenthDTO.getLeadCaptureId())));
        entity.setCoreTenthMarkingScheme(schemeRepository
                .findById(detailsForTenthDTO.getCoreTenthMarkingSchemeId())
                .orElseThrow(()->new Core10thMarkingSchemeNotFoundException("10th Marking Scheme Not found with this id : " + detailsForTenthDTO.getCoreTenthMarkingSchemeId())));
        entity.setTenthMarksOrGrade(detailsForTenthDTO.getTenthMarksOrGrade());
        return entity;
    }
}
