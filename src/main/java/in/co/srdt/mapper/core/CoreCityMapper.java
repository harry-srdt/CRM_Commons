package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreCityDto;
import in.co.srdt.entity.coresetup.CoreCity;
import org.springframework.stereotype.Component;

@Component
public class CoreCityMapper {

    public CoreCityDto toDto(CoreCity entity){
        if (entity==null)
            return null;
        CoreCityDto dto = new CoreCityDto();
        dto.setCoreCityId(entity.getCoreCityId());
        dto.setCoreStateId(entity.getCoreState().getCoreStateId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreCity toEntity(CoreCityDto dto){
        if (dto==null)
            return null;
        CoreCity entity = new CoreCity();
        entity.setCoreCityId(dto.getCoreCityId());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
