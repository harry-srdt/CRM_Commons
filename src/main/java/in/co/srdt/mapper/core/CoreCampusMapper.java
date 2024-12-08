package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreCampusDto;
import in.co.srdt.entity.coresetup.CoreCampus;
import org.springframework.stereotype.Component;

@Component
public class CoreCampusMapper {

    public CoreCampusDto toDto(CoreCampus coreCampus) {
        if (coreCampus == null)
            return null;
        CoreCampusDto dto = new CoreCampusDto();
        dto.setCampusId(coreCampus.getCampusId());
        dto.setName(coreCampus.getName());
        dto.setDisplayName(coreCampus.getDisplayName());
        dto.setStatus(coreCampus.getStatus());
        return dto;
    }

    public CoreCampus toEntity(CoreCampusDto coreCampusDto) {
        if (coreCampusDto == null)
            return null;
        CoreCampus entity = new CoreCampus();
        entity.setCampusId(coreCampusDto.getCampusId());
        entity.setName(coreCampusDto.getName());
        entity.setDisplayName(coreCampusDto.getDisplayName());
        entity.setStatus(coreCampusDto.getStatus());
        return entity;
    }
}
