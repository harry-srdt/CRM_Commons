package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreTwelveMarkingSchemeDto;
import in.co.srdt.entity.coresetup.CoreTwelveMarkingScheme;
import org.springframework.stereotype.Component;

@Component
public class CoreTwelveMarkingSchemeMapper {

    public CoreTwelveMarkingSchemeDto toDto(CoreTwelveMarkingScheme entity){
        if (entity==null)
            return null;
        CoreTwelveMarkingSchemeDto dto = new CoreTwelveMarkingSchemeDto();
        dto.setTwelveMarkingSchemeId(entity.getTwelveMarkingSchemeId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreTwelveMarkingScheme toEntity(CoreTwelveMarkingSchemeDto dto){
        if (dto==null)
            return null;
        CoreTwelveMarkingScheme entity = new CoreTwelveMarkingScheme();
        entity.setTwelveMarkingSchemeId(dto.getTwelveMarkingSchemeId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
