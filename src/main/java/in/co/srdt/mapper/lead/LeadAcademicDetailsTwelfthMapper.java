package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadAcademicDetailsTwelfthDTO;
import in.co.srdt.entity.coresetup.Core12thBoard;
import in.co.srdt.entity.coresetup.CoreTwelveMarkingScheme;
import in.co.srdt.entity.lead.LeadAcademicDetailsTwelfth;
import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.exception.lead.ResourceNotFoundException;
import in.co.srdt.repository.core.Core12thBoardRepository;
import in.co.srdt.repository.core.CoreTwelveMarkingSchemeRepository;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadAcademicDetailsTwelfthMapper {

    private final LeadCaptureRepository captureRepository;
    private final Core12thBoardRepository boardRepository;
    private final CoreTwelveMarkingSchemeRepository schemeRepository;

    public LeadAcademicDetailsTwelfthDTO toDto(LeadAcademicDetailsTwelfth detailsTwelfth){
        if (detailsTwelfth==null)
            return null;
        LeadAcademicDetailsTwelfthDTO dto = new LeadAcademicDetailsTwelfthDTO();

        dto.setAcademicDetailsTwelfthId(detailsTwelfth.getAcademicDetailsTwelfthId());
        dto.setLeadCaptureId(detailsTwelfth.getLeadCapture() != null ? detailsTwelfth.getLeadCapture().getLeadCaptureId() : null);
        dto.setSchool(detailsTwelfth.getSchool());
        dto.setTwelveBoardId(detailsTwelfth.getTwelveBoard() != null ? detailsTwelfth.getTwelveBoard().getCore12thBoardId() : null);
        dto.setTwelveMarkingSchemeId(detailsTwelfth.getTwelveMarkingScheme() != null ? detailsTwelfth.getTwelveMarkingScheme().getTwelveMarkingSchemeId() : null);
        dto.setTwelveMarksOrGrade(detailsTwelfth.getTwelveMarksOrGrade());
        dto.setTwelveResultStatus(detailsTwelfth.getTwelveResultStatus());
        dto.setTwelveBoardName(detailsTwelfth.getTwelveBoard().getName());
        dto.setTwelveMarkingSchemeName(detailsTwelfth.getTwelveMarkingScheme().getName());
        return dto;
    }

    public LeadAcademicDetailsTwelfth toEntity(LeadAcademicDetailsTwelfthDTO dto) {
        if (dto == null) {
            return null;
        }

        LeadAcademicDetailsTwelfth detailsTwelfth = new LeadAcademicDetailsTwelfth();
        detailsTwelfth.setAcademicDetailsTwelfthId(dto.getAcademicDetailsTwelfthId());

        LeadCapture leadCapture = captureRepository.findById(dto.getLeadCaptureId())
                .orElseThrow(() -> new ResourceNotFoundException("Lead Capture not found with ID: " + dto.getLeadCaptureId()));
        detailsTwelfth.setLeadCapture(leadCapture);

        detailsTwelfth.setSchool(dto.getSchool());

        Core12thBoard twelveBoard = boardRepository.findById(dto.getTwelveBoardId())
                .orElseThrow(() -> new ResourceNotFoundException("12th Board not found with ID: " + dto.getTwelveBoardId()));
        detailsTwelfth.setTwelveBoard(twelveBoard);

        CoreTwelveMarkingScheme markingScheme = schemeRepository.findById(dto.getTwelveMarkingSchemeId())
                .orElseThrow(() -> new ResourceNotFoundException("Marking Scheme not found with ID: " + dto.getTwelveMarkingSchemeId()));
        detailsTwelfth.setTwelveMarkingScheme(markingScheme);

        detailsTwelfth.setTwelveMarksOrGrade(dto.getTwelveMarksOrGrade());
        detailsTwelfth.setTwelveResultStatus(dto.getTwelveResultStatus());
        return detailsTwelfth;
    }

}
