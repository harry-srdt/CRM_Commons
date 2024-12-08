package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.Core10thMarkingSchemeDto;
import in.co.srdt.entity.coresetup.Core10thMarkingScheme;
import org.springframework.stereotype.Component;

@Component
public class Core10thMarkingSchemeMapper {

    public Core10thMarkingSchemeDto toDto(Core10thMarkingScheme entity){
        if (entity==null)
            return null;
        Core10thMarkingSchemeDto dto = new Core10thMarkingSchemeDto();
        dto.setCore10thMarkingSchemeId(entity.getCore10thMarkingSchemeId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Core10thMarkingScheme toEntity(Core10thMarkingSchemeDto dto){
        if (dto==null)
                return null;
        Core10thMarkingScheme entity = new Core10thMarkingScheme();
        entity.setCore10thMarkingSchemeId(dto.getCore10thMarkingSchemeId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
        }

}
