package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreInstalmentStageDto;
import in.co.srdt.entity.coresetup.CoreInstalmentStage;
import org.springframework.stereotype.Component;

@Component
public class CoreInstalmentStageMapper {

    public CoreInstalmentStageDto toDto(CoreInstalmentStage instalmentStage){
        if (instalmentStage==null)
            return null;
        CoreInstalmentStageDto dto = new CoreInstalmentStageDto();
        dto.setInstalmentStageId(instalmentStage.getInstalmentStageId());
        dto.setName(instalmentStage.getName());
        dto.setDisplayName(instalmentStage.getDisplayName());
        dto.setStatus(instalmentStage.getStatus());
        return dto;
    }

    public CoreInstalmentStage toEntity(CoreInstalmentStageDto instalmentStageDto){
        if (instalmentStageDto==null)
            return null;
        CoreInstalmentStage entity = new CoreInstalmentStage();
        entity.setInstalmentStageId(instalmentStageDto.getInstalmentStageId());
        entity.setName(instalmentStageDto.getName());
        entity.setDisplayName(instalmentStageDto.getDisplayName());
        entity.setStatus(instalmentStageDto.getStatus());
        return entity;
    }
}
