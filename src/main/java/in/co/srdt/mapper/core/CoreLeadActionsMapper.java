package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreLeadActionsDto;
import in.co.srdt.entity.coresetup.CoreLeadActions;
import org.springframework.stereotype.Component;

@Component
public class CoreLeadActionsMapper {

    public CoreLeadActionsDto toDto(CoreLeadActions entity) {
        if (entity == null)
            return null;
        CoreLeadActionsDto dto = new CoreLeadActionsDto();
        dto.setCoreLeadActionsId(entity.getCoreLeadActionsId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setStatus(entity.getStatus());
        dto.setIconName(entity.getIconName());
        return dto;
    }

    public CoreLeadActions toEntity(CoreLeadActionsDto dto) {
        if (dto == null)
            return null;
        CoreLeadActions entity = new CoreLeadActions();
        entity.setCoreLeadActionsId(dto.getCoreLeadActionsId());
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
        entity.setStatus(dto.getStatus());
        entity.setIconName(dto.getIconName());
        return entity;
    }
}
