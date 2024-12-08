package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadAcademicDetailsDiplomaDTO;
import in.co.srdt.entity.lead.LeadAcademicDetailsDiploma;
import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.exception.lead.ResourceNotFoundException;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadAcademicDetailsDiplomaMapper {

    private final LeadCaptureRepository captureRepository;

    public LeadAcademicDetailsDiplomaDTO toDto(LeadAcademicDetailsDiploma detailsDiploma){
        if (detailsDiploma==null)
            return null;
        LeadAcademicDetailsDiplomaDTO dto = new LeadAcademicDetailsDiplomaDTO();
        dto.setAcademicDetailsDiplomaId(detailsDiploma.getAcademicDetailsDiplomaId());
        dto.setLeadCaptureId(detailsDiploma.getLeadCapture() != null ? detailsDiploma.getLeadCapture().getLeadCaptureId() : null);
        dto.setSchool(detailsDiploma.getSchool());
        dto.setDiplomaBoard(detailsDiploma.getDiplomaBoard());
        dto.setResultStatus(detailsDiploma.getResultStatus() != null ? detailsDiploma.getResultStatus() : null);
        dto.setMarks(detailsDiploma.getMarks());

        return dto;
    }

    public LeadAcademicDetailsDiploma toEntity(LeadAcademicDetailsDiplomaDTO dto) {
        if (dto == null)
            return null;
        LeadAcademicDetailsDiploma diplomaDetails = new LeadAcademicDetailsDiploma();
        diplomaDetails.setAcademicDetailsDiplomaId(dto.getAcademicDetailsDiplomaId());

        LeadCapture leadCapture = captureRepository.findById(dto.getLeadCaptureId())
                .orElseThrow(() -> new ResourceNotFoundException("LeadCapture not found with ID: " + dto.getLeadCaptureId()));
        diplomaDetails.setLeadCapture(leadCapture);

        diplomaDetails.setSchool(dto.getSchool());
        diplomaDetails.setDiplomaBoard(dto.getDiplomaBoard());
        diplomaDetails.setResultStatus(dto.getResultStatus());
        diplomaDetails.setMarks(dto.getMarks());

        return diplomaDetails;
    }

}
