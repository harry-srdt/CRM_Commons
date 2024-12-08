package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreActivityOutcomeDto;
import in.co.srdt.entity.coresetup.CoreActivityOutcome;
import org.springframework.stereotype.Component;

@Component
public class CoreActivityOutcomeMapper {

    public CoreActivityOutcomeDto toDto(CoreActivityOutcome entity){
        if (entity==null)
            return null;
        CoreActivityOutcomeDto dto = new CoreActivityOutcomeDto();
        dto.setActivityOutcomeId(entity.getActivityOutcomeId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreActivityOutcome toEntity(CoreActivityOutcomeDto dto){
        if (dto==null)
            return null;
        CoreActivityOutcome entity = new CoreActivityOutcome();
        entity.setActivityOutcomeId(dto.getActivityOutcomeId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
