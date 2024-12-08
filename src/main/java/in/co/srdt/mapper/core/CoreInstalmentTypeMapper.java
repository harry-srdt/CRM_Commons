package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreInstalmentTypeDto;
import in.co.srdt.entity.coresetup.CoreInstalmentType;
import org.springframework.stereotype.Component;

@Component
public class CoreInstalmentTypeMapper {

    public CoreInstalmentTypeDto toDto(CoreInstalmentType instalmentType){
        if (instalmentType==null)
            return null;
        CoreInstalmentTypeDto dto = new CoreInstalmentTypeDto();
        dto.setInstalmentTypeId(instalmentType.getInstalmentTypeId());
        dto.setName(instalmentType.getName());
        dto.setDisplayName(instalmentType.getDisplayName());
        dto.setStatus(instalmentType.getStatus());
        return dto;
    }

    public CoreInstalmentType toEntity(CoreInstalmentTypeDto instalmentTypeDto){
        if (instalmentTypeDto==null)
            return null;
        CoreInstalmentType entity = new CoreInstalmentType();
        entity.setInstalmentTypeId(instalmentTypeDto.getInstalmentTypeId());
        entity.setName(instalmentTypeDto.getName());
        entity.setDisplayName(instalmentTypeDto.getDisplayName());
        entity.setStatus(instalmentTypeDto.getStatus());
        return entity;
    }

}
