package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadStageDTO;
import in.co.srdt.entity.coresetup.CoreLeadStage;
import in.co.srdt.entity.coresetup.CoreLeadSubStage;
import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.entity.lead.LeadStage;
import in.co.srdt.repository.core.CoreLeadStageRepository;
import in.co.srdt.repository.core.CoreLeadSubStageRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LeadStageMapper {

    private final CoreLeadStageRepository coreLeadStageRepository;
    private final CoreLeadSubStageRepository coreLeadSubStageRepository;

    public LeadStageMapper(CoreLeadStageRepository coreLeadStageRepository,
                           CoreLeadSubStageRepository coreLeadSubStageRepository) {
        this.coreLeadStageRepository = coreLeadStageRepository;
        this.coreLeadSubStageRepository = coreLeadSubStageRepository;
    }

    public LeadStageDTO toDto(LeadStage leadStage) {
        if (leadStage == null) {
            return null;
        }

        LeadStageDTO dto = new LeadStageDTO();
        dto.setLeadStageId(leadStage.getLeadStageId());
        dto.setCoreLeadStageId(leadStage.getCoreLeadStage() != null ? leadStage.getCoreLeadStage().getLeadStageId() : null);
        dto.setCoreLeadSubStageId(leadStage.getCoreLeadSubStage() != null ? leadStage.getCoreLeadSubStage().getLeadSubStageId() : null);

        List<Long> leadCaptureIds = leadStage.getLeadCaptures().stream()
                .map(LeadCapture::getLeadCaptureId)
                .collect(Collectors.toList());
        dto.setLeadCaptureIds(leadCaptureIds);

        return dto;
    }

    public LeadStage toEntity(LeadStageDTO leadStageDto) {
        if (leadStageDto == null) return null;

        LeadStage leadStage = new LeadStage();
        leadStage.setLeadStageId(leadStageDto.getLeadStageId());

        if (leadStageDto.getCoreLeadStageId() != null) {
            CoreLeadStage coreLeadStage = coreLeadStageRepository.findById(leadStageDto.getCoreLeadStageId())
                    .orElseThrow(() -> new RuntimeException("CoreLeadStage not found with id: " + leadStageDto.getCoreLeadStageId()));
            leadStage.setCoreLeadStage(coreLeadStage);
        }

        if (leadStageDto.getCoreLeadSubStageId() != null) {
            CoreLeadSubStage coreLeadSubStage = coreLeadSubStageRepository.findById(leadStageDto.getCoreLeadSubStageId())
                    .orElseThrow(() -> new RuntimeException("CoreLeadSubStage not found with id: " + leadStageDto.getCoreLeadSubStageId()));
            leadStage.setCoreLeadSubStage(coreLeadSubStage);
        }

        return leadStage;
    }
}
