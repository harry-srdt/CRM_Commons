package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreFormSourceDto;
import in.co.srdt.entity.coresetup.CoreFormSource;
import org.springframework.stereotype.Component;

@Component
public class CoreFormSourceMapper {

    public CoreFormSourceDto toDto(CoreFormSource entity){
        if (entity==null)
            return null;
        CoreFormSourceDto dto = new CoreFormSourceDto();
        dto.setFormSourceId(entity.getFormSourceId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreFormSource toEntity(CoreFormSourceDto dto){
        if (dto==null)
            return null;
        CoreFormSource entity = new CoreFormSource();
        entity.setFormSourceId(dto.getFormSourceId());
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
        entity.setStatus(dto.getStatus());
        return entity;
    }

}
