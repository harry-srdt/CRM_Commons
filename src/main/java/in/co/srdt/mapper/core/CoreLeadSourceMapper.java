package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreLeadSourceDto;
import in.co.srdt.entity.coresetup.CoreLeadSource;
import org.springframework.stereotype.Component;

@Component
public class CoreLeadSourceMapper {
    public CoreLeadSourceDto toDto(CoreLeadSource entity) {
        if(entity==null)
            return null;
        CoreLeadSourceDto dto = new CoreLeadSourceDto();
        dto.setLeadSourceId(entity.getLeadSourceId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreLeadSource toEntity(CoreLeadSourceDto dto) {
        if (dto==null)
            return null;
        CoreLeadSource entity = new CoreLeadSource();
        entity.setLeadSourceId(dto.getLeadSourceId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
