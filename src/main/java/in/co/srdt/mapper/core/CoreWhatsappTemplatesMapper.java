package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreWhatsappMediaAttachmentDto;
import in.co.srdt.dto.core.CoreWhatsappTemplatesDto;
import in.co.srdt.entity.coresetup.CoreWhatsappMediaAttachment;
import in.co.srdt.entity.coresetup.CoreWhatsappTemplates;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CoreWhatsappTemplatesMapper {


    public CoreWhatsappTemplatesDto toDto(CoreWhatsappTemplates templates) {
        if (templates == null)
            return null;
        CoreWhatsappTemplatesDto dto = new CoreWhatsappTemplatesDto();
        dto.setCoreWhatsappTemplatesId(templates.getCoreWhatsappTemplatesId());
        dto.setName(templates.getName());
        dto.setDisplayName(templates.getDisplayName());
        dto.setTemplateType(templates.getTemplateType());
        dto.setContent(templates.getContent());
        dto.setIsVariableUsed(templates.getIsVariableUsed());
        dto.setIsMediaAttached(templates.getIsMediaAttached());

        CoreWhatsappMediaAttachmentDto mediaAttachmentDto = new CoreWhatsappMediaAttachmentDto();
        if (templates.getCoreWhatsappMediaAttachment()!=null) {
            mediaAttachmentDto.setCoreWhatsappMediaAttachmentId(templates.getCoreWhatsappMediaAttachment().getCoreWhatsappMediaAttachmentId());
            mediaAttachmentDto.setWhatsappTemplatesId(templates.getCoreWhatsappTemplatesId());
            mediaAttachmentDto.setType(templates.getCoreWhatsappMediaAttachment().getType());
            mediaAttachmentDto.setUrl(templates.getCoreWhatsappMediaAttachment().getUrl());
            dto.setCoreWhatsappMediaAttachmentDto(mediaAttachmentDto);
        }
        return dto;
    }

    public CoreWhatsappTemplates toEntity(CoreWhatsappTemplatesDto templatesDto) {
        if (templatesDto == null)
            return null;
        CoreWhatsappTemplates entity = new CoreWhatsappTemplates();
        entity.setName(templatesDto.getName());
        entity.setDisplayName(templatesDto.getDisplayName());
        entity.setTemplateType(templatesDto.getTemplateType());
        entity.setContent(templatesDto.getContent());
        entity.setIsVariableUsed(templatesDto.getIsVariableUsed());
        entity.setIsMediaAttached(templatesDto.getIsMediaAttached());

        if (templatesDto.getCoreWhatsappMediaAttachmentDto()!=null) {
            CoreWhatsappMediaAttachment coreWhatsappMediaAttachment = new CoreWhatsappMediaAttachment();
            coreWhatsappMediaAttachment.setWhatsappTemplates(entity);
            coreWhatsappMediaAttachment.setType(templatesDto.getCoreWhatsappMediaAttachmentDto().getType());
            coreWhatsappMediaAttachment.setUrl(templatesDto.getCoreWhatsappMediaAttachmentDto().getUrl());
            entity.setCoreWhatsappMediaAttachment(coreWhatsappMediaAttachment);
        }

        return entity;
    }

}
