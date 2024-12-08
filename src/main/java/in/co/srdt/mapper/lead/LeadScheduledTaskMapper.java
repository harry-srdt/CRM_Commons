package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadScheduledTaskDTO;
import in.co.srdt.entity.lead.LeadScheduledTask;
import in.co.srdt.repository.core.CoreSalesRepDetailsRepository;
import in.co.srdt.repository.core.CoreTaskTypeRepository;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadScheduledTaskMapper {

    private final CoreTaskTypeRepository coreTaskTypeRepository;
    private final CoreSalesRepDetailsRepository salesRepDetailsRepository;
    private final LeadCaptureRepository leadCaptureRepository;

    public LeadScheduledTaskDTO toDto(LeadScheduledTask entity) {
        if (entity == null) {
            return null;
        }

        LeadScheduledTaskDTO dto = new LeadScheduledTaskDTO();
        dto.setLeadScheduledTaskId(entity.getLeadScheduledTaskId());
        dto.setCoreTaskTypeId(entity.getCoreTaskType().getCoreTaskTypeId());
        dto.setSalesrpDetailsId(entity.getSalesrpDetails() != null ? entity.getSalesrpDetails().getSalesrpDetailsId() : null);
        dto.setLeadCaptureId(entity.getLeadCapture() != null ? entity.getLeadCapture().getLeadCaptureId() : null);
        dto.setSubject(entity.getSubject());
        dto.setScheduledDate(entity.getScheduledDate());
        dto.setScheduledTime(entity.getScheduledTime());
        dto.setLocation(entity.getLocation());
        dto.setTaskDetails(entity.getTaskDetails());
        dto.setOrganizer(entity.getOrganizer());
        dto.setCompleted(entity.isCompleted());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setLeadCaptureName(entity.getLeadCapture().getName());
        dto.setSalesrpDetailsName(entity.getSalesrpDetails().getFullName());
        dto.setCoreTaskTypeName(entity.getCoreTaskType().getName());
        return dto;
    }

    public LeadScheduledTask toEntity(LeadScheduledTaskDTO dto) {
        if (dto == null) {
            return null;
        }

        LeadScheduledTask entity = new LeadScheduledTask();
        entity.setLeadScheduledTaskId(dto.getLeadScheduledTaskId());

        dto.setCoreTaskTypeId(dto.getCoreTaskTypeId());

        if (dto.getSalesrpDetailsId() != null) {
            entity.setSalesrpDetails(
                    salesRepDetailsRepository.findById(dto.getSalesrpDetailsId())
                            .orElseThrow(() -> new IllegalArgumentException("Invalid SalesRepDetails ID: " + dto.getSalesrpDetailsId()))
            );
        }

        if (dto.getLeadCaptureId() != null) {
            entity.setLeadCapture(
                    leadCaptureRepository.findById(dto.getLeadCaptureId())
                            .orElseThrow(() -> new IllegalArgumentException("Invalid LeadCapture ID: " + dto.getLeadCaptureId()))
            );
        }

        entity.setSubject(dto.getSubject());
        entity.setScheduledDate(dto.getScheduledDate());
        entity.setScheduledTime(dto.getScheduledTime());
        entity.setLocation(dto.getLocation());
        entity.setTaskDetails(dto.getTaskDetails());
        entity.setOrganizer(dto.getOrganizer());
        entity.setCompleted(dto.isCompleted());
        return entity;
    }
}
