package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreSalesrpLeadLastAssignedDto;
import in.co.srdt.entity.coresetup.CoreSalesrpLeadLastAssigned;
import org.springframework.stereotype.Component;

@Component
public class CoreSalesrpLeadLastAssignedMapper {

    public CoreSalesrpLeadLastAssignedDto toDto(CoreSalesrpLeadLastAssigned lastAssigned){
        if (lastAssigned==null)
            return null;

        CoreSalesrpLeadLastAssignedDto dto =  new CoreSalesrpLeadLastAssignedDto();
        dto.setCoreSalesrpLeadLastAssignedId(lastAssigned.getCoreSalesrpLeadLastAssignedId());
        dto.setPrioritySequence(lastAssigned.getPrioritySequence());
        return dto;
    }

    public CoreSalesrpLeadLastAssigned toEntity(CoreSalesrpLeadLastAssignedDto lastAssigned){
        if (lastAssigned==null)
            return null;

        CoreSalesrpLeadLastAssigned entity =  new CoreSalesrpLeadLastAssigned();
        entity.setCoreSalesrpLeadLastAssignedId(lastAssigned.getCoreSalesrpLeadLastAssignedId());
        entity.setPrioritySequence(lastAssigned.getPrioritySequence());
        return entity;
    }
}
