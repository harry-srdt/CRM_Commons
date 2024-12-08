package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreLeadSubStageDto;
import in.co.srdt.entity.coresetup.CoreLeadSubStage;
import in.co.srdt.exception.core.CoreLeadSubStageNotFoundException;
import in.co.srdt.repository.core.CoreLeadStageRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class CoreLeadSubStageMapper {

    private final CoreLeadStageRepository StageRepository;

    public CoreLeadSubStageDto toDto(CoreLeadSubStage leadSubStage){
        if(leadSubStage==null)
            return null;
        CoreLeadSubStageDto dto = new CoreLeadSubStageDto();
        dto.setLeadSubStageId(leadSubStage.getLeadSubStageId());
        dto.setLeadStageId(leadSubStage.getLeadSubStageId());
        dto.setName(leadSubStage.getName());
        dto.setDisplayName(leadSubStage.getDisplayName());
        dto.setStatus(leadSubStage.getStatus());
        return dto;
    }

    public CoreLeadSubStage toEntity(CoreLeadSubStageDto leadSubStageDto){
        if(leadSubStageDto==null)
            return null;
        CoreLeadSubStage entity = new CoreLeadSubStage();
        entity.setLeadSubStageId(leadSubStageDto.getLeadSubStageId());
        entity.setCoreLeadStage(StageRepository.findById(leadSubStageDto.getLeadStageId())
                .orElseThrow(()-> new CoreLeadSubStageNotFoundException("Lead Sub Stage Not Found With This Id : " + leadSubStageDto.getLeadStageId())));
        entity.setName(leadSubStageDto.getName());
        entity.setDisplayName(leadSubStageDto.getDisplayName());
        entity.setStatus(leadSubStageDto.getStatus());
        return entity;
    }
}
