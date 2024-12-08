package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreRecruitingCenterDto;
import in.co.srdt.entity.coresetup.CoreRecruitingCenter;
import org.springframework.stereotype.Component;

@Component
public class CoreRecruitingCenterMapper {

    public CoreRecruitingCenterDto toDto(CoreRecruitingCenter entity){
        if(entity==null)
            return null;
        CoreRecruitingCenterDto dto = new CoreRecruitingCenterDto();
        dto.setRecruitingCenterId(entity.getRecruitingCenterId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }
    public CoreRecruitingCenter toEntity(CoreRecruitingCenterDto dto){
        if (dto==null)
            return null;
        CoreRecruitingCenter entity =  new CoreRecruitingCenter();
        entity.setRecruitingCenterId(dto.getRecruitingCenterId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
