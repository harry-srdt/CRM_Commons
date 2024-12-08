package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreTwelveResultStatusDto;
import in.co.srdt.entity.coresetup.CoreTwelveResultStatus;
import org.springframework.stereotype.Component;

@Component
public class CoreTwelveResultStatusMapper {

    public CoreTwelveResultStatusDto toDto(CoreTwelveResultStatus entity){
        if (entity==null)
            return null;
        CoreTwelveResultStatusDto dto = new CoreTwelveResultStatusDto();
       dto.setTwelveMarkingSchemeId(entity.getTwelveMarkingSchemeId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreTwelveResultStatus toEntity(CoreTwelveResultStatusDto dto){
        if (dto==null)
            return null;
        CoreTwelveResultStatus entity = new CoreTwelveResultStatus();
        entity.setTwelveMarkingSchemeId(dto.getTwelveMarkingSchemeId());
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
