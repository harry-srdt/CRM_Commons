package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreDocAttachmentTypeDto;
import in.co.srdt.entity.coresetup.CoreDocAttachmentType;
import in.co.srdt.mapper.lead.LeadDocAttachmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CoreDocAttachmentTypeMapper {

    private final LeadDocAttachmentMapper leadDocAttachmentMapper;

    public CoreDocAttachmentTypeDto toDto(CoreDocAttachmentType entity){
        if (entity==null)
            return null;

        CoreDocAttachmentTypeDto dto = new CoreDocAttachmentTypeDto();
        dto.setCoreDocAttachmentTypeId(entity.getCoreDocAttachmentTypeId());
        dto.setName(entity.getName());
        dto.setLeadDocAttachmentDTOS(entity.getLeadDocAttachmentList().stream().map(leadDocAttachmentMapper::toDto).toList());

        return dto;
    }

    public CoreDocAttachmentType toEntity(CoreDocAttachmentTypeDto dto){
        if (dto==null)
            return null;

        CoreDocAttachmentType entity = new CoreDocAttachmentType();

        entity.setCoreDocAttachmentTypeId(dto.getCoreDocAttachmentTypeId());
        entity.setName(dto.getName());
        entity.setLeadDocAttachmentList(dto.getLeadDocAttachmentDTOS().stream().map(leadDocAttachmentMapper::toEntity).toList());
        return entity;
    }
}
