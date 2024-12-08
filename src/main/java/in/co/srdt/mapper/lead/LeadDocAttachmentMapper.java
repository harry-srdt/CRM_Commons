package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadDocAttachmentDTO;
import in.co.srdt.entity.coresetup.CoreDocAttachmentType;
import in.co.srdt.entity.lead.LeadDocAttachment;
import in.co.srdt.exception.lead.ResourceNotFoundException;
import in.co.srdt.repository.core.CoreDocAttachmentTypeRepository;
import in.co.srdt.repository.lead.LeadNotesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadDocAttachmentMapper {

    private final LeadNotesRepository leadNotesRepository;
    private final CoreDocAttachmentTypeRepository docAttachmentTypeRepository;

    public LeadDocAttachmentDTO toDto(LeadDocAttachment entity){
        if (entity==null)
            return null;

        LeadDocAttachmentDTO dto =new LeadDocAttachmentDTO();
        dto.setLeadDocAttachmentId(entity.getLeadDocAttachmentId());
        dto.setName(entity.getName());
        dto.setLeadCaptureId(entity.getLeadCaptureId());
        dto.setCoreDocAttachmentTypeId(entity.getCoreDocAttachmentType()!=null?entity.getCoreDocAttachmentType().getCoreDocAttachmentTypeId():null);

        if (entity.getCoreDocAttachmentType() != null) {
            dto.setCoreDocAttachmentTypeId(entity.getCoreDocAttachmentType().getCoreDocAttachmentTypeId());
        }

        return dto;
    }

    public LeadDocAttachment toEntity(LeadDocAttachmentDTO dto){
        if (dto==null)
            return null;

        LeadDocAttachment entity = new LeadDocAttachment();
        entity.setLeadDocAttachmentId(dto.getLeadDocAttachmentId());
        entity.setName(dto.getName());
        entity.setLeadCaptureId(dto.getLeadCaptureId());

        CoreDocAttachmentType docAttachmentType=  docAttachmentTypeRepository
                .findById(dto
                        .getCoreDocAttachmentTypeId())
                .orElseThrow(()->new ResourceNotFoundException("Core Doc Attachment not found with this id : " + dto.getCoreDocAttachmentTypeId()));
        entity.setCoreDocAttachmentType(docAttachmentType);
        return entity;
    }
}
