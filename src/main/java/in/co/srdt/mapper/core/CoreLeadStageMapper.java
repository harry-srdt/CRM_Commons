package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreLeadStageDto;
import in.co.srdt.entity.coresetup.CoreLeadStage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CoreLeadStageMapper {

    private final CoreLeadSubStageMapper subStageMapper;

    public CoreLeadStageDto toDto(CoreLeadStage leadStage){
        if(leadStage==null)
            return null;
        CoreLeadStageDto dto = new CoreLeadStageDto();
        dto.setLeadStageId(leadStage.getLeadStageId());
        dto.setName(leadStage.getName());
        dto.setStatus(leadStage.getStatus());
        dto.setDisplayName(leadStage.getDisplayName());
       /* if (dto.getLeadSubStage() != null) {
            dto.setLeadSubStage(leadStage.getLeadSubStage().stream().map(subStageMapper::toDto).toList());
        }*/
        return dto;
    }

    public CoreLeadStage toEntity(CoreLeadStageDto leadStageDto){
        if (leadStageDto==null)
            return null;
        CoreLeadStage entity = new CoreLeadStage();
        entity.setLeadStageId(leadStageDto.getLeadStageId());
        entity.setName(leadStageDto.getName());
        entity.setDisplayName(leadStageDto.getDisplayName());
        entity.setStatus(leadStageDto.getStatus());
       /* entity.setLeadSubStage(leadStageDto.getLeadSubStage()!=null?leadStageDto.getLeadSubStage()
                .stream().map(subStageMapper::toEntity).toList(): Collections.emptyList());*/
        return entity;
    }
}
