package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadDocAttachmentDTO;
import in.co.srdt.dto.lead.LeadNotesDTO;
import in.co.srdt.entity.coresetup.CoreDocAttachmentType;
import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.entity.lead.LeadDocAttachment;
import in.co.srdt.entity.lead.LeadNotes;
import in.co.srdt.exception.lead.ResourceNotFoundException;
import in.co.srdt.repository.core.CoreDocAttachmentTypeRepository;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class LeadNotesMapper {

    private final LeadCaptureRepository leadCaptureRepository;
    private final CoreDocAttachmentTypeRepository coreDocAttachmentTypeRepository;

    public LeadNotes toEntity(LeadNotesDTO dto,String currentUser) {
        if (dto == null) {
            return null;
        }

        LeadNotes entity = new LeadNotes();
        entity.setNote(dto.getNote());

        LeadCapture leadCapture = leadCaptureRepository
                .findById(dto.getLeadCaptureId())
                .orElseThrow(() -> new ResourceNotFoundException("Lead Capture not found with this id : " + dto.getLeadCaptureId()));
        entity.setLeadCapture(leadCapture);

        LeadDocAttachmentDTO leadDocAttachmentDTO = dto.getLeadDocAttachmentDTO();

        LeadDocAttachment leadDocAttachment = new LeadDocAttachment();

        CoreDocAttachmentType coreDocAttachmentType = coreDocAttachmentTypeRepository
                .findById(leadDocAttachmentDTO
                        .getCoreDocAttachmentTypeId())
                .orElseThrow(()->new ResourceNotFoundException("Core Doc Attachment Type not found with this id : " + leadDocAttachmentDTO.getCoreDocAttachmentTypeId()));

        leadDocAttachment.setCoreDocAttachmentType(coreDocAttachmentType);
        leadDocAttachment.setName(leadDocAttachmentDTO.getName());
        leadDocAttachment.setLeadCaptureId(leadDocAttachmentDTO.getLeadCaptureId());
        leadDocAttachment.setCreatedBy(currentUser);
        leadDocAttachment.setUpdatedBy(currentUser);

        entity.setLeadDocAttachment(leadDocAttachment);

        return entity;
    }

    public LeadNotesDTO toDto(LeadNotes leadNotes) {
        if (leadNotes == null)
            return null;

        LeadNotesDTO dto = new LeadNotesDTO();
        dto.setLeadNotesId(leadNotes.getLeadNotesId());
        dto.setLeadCaptureId(leadNotes.getLeadCapture().getLeadCaptureId());
        dto.setNote(leadNotes.getNote());

        LeadDocAttachment leadDocAttachment = leadNotes.getLeadDocAttachment();

        if (leadDocAttachment != null) {
            LeadDocAttachmentDTO attachmentDTO = new LeadDocAttachmentDTO();
            attachmentDTO.setLeadDocAttachmentId(leadDocAttachment.getLeadDocAttachmentId());
            attachmentDTO.setName(leadDocAttachment.getName());
            attachmentDTO.setLeadCaptureId(leadDocAttachment.getLeadCaptureId());
            attachmentDTO.setCoreDocAttachmentTypeId(leadDocAttachment.getCoreDocAttachmentType().getCoreDocAttachmentTypeId());
            dto.setLeadDocAttachmentDTO(attachmentDTO);
            dto.setUpdatedBy(leadNotes.getUpdatedBy());
            dto.setUpdatedAt(leadNotes.getUpdatedAt());
        }

        return dto;
    }


}
