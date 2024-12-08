package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreSalesrpLeadAssignmentPriorityDto;
import in.co.srdt.entity.coresetup.CoreSalesrpLeadAssignmentPriority;
import org.springframework.stereotype.Component;

@Component
public class CoreSalesrpLeadAssignmentPriorityMapper {

    public CoreSalesrpLeadAssignmentPriorityDto toDto(CoreSalesrpLeadAssignmentPriority priority){
        if (priority==null)
            return null;

        CoreSalesrpLeadAssignmentPriorityDto dto = new CoreSalesrpLeadAssignmentPriorityDto();
        dto.setCoreSalesrpLeadAssignmentPriorityId(priority.getCoreSalesrpLeadAssignmentPriorityId());
        dto.setPrioritySequence(priority.getPrioritySequence());
        dto.setManagerId(priority.getManagerId());
        return dto;
    }

    public CoreSalesrpLeadAssignmentPriority toEntity(CoreSalesrpLeadAssignmentPriorityDto priorityDto ){
        if (priorityDto==null)
            return null;

        CoreSalesrpLeadAssignmentPriority entity = new CoreSalesrpLeadAssignmentPriority();
        entity.setCoreSalesrpLeadAssignmentPriorityId(priorityDto.getCoreSalesrpLeadAssignmentPriorityId());
        entity.setPrioritySequence(priorityDto.getPrioritySequence());
        entity.setManagerId(priorityDto.getManagerId());
        return entity;
    }
}
