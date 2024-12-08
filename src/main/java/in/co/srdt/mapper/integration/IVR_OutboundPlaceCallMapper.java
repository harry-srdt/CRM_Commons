package in.co.srdt.mapper.integration;

import in.co.srdt.dto.integration.IVR_OutboundPlaceCallDTO;
import in.co.srdt.entity.integration.IVR_OutboundPlaceCall;
import org.springframework.stereotype.Component;

@Component
public class IVR_OutboundPlaceCallMapper {

    public IVR_OutboundPlaceCallDTO toDto(IVR_OutboundPlaceCall call){
        if (call==null)
            return null;

        IVR_OutboundPlaceCallDTO dto = new IVR_OutboundPlaceCallDTO();
        dto.setIvrOutboundPlaceCallId(call.getIvrOutboundPlaceCallId());
        dto.setMessage(call.getMessage());
        dto.setCallId(call.getCallId());
        dto.setStatus(call.getStatus());
        dto.setRefId(call.getRefId());
        dto.setCreatedAt(call.getCreatedAt());
        dto.setLeadCaptureId(call.getLeadCaptureId());

        return dto;
    }

    public IVR_OutboundPlaceCall toEntity(IVR_OutboundPlaceCallDTO callDTO){
        if (callDTO==null)
            return null;

        IVR_OutboundPlaceCall entity = new IVR_OutboundPlaceCall();
        entity.setStatus(callDTO.getStatus());
        entity.setCreatedAt(callDTO.getCreatedAt());
        entity.setMessage(callDTO.getMessage());
        entity.setRefId(callDTO.getRefId());
        entity.setCallId(callDTO.getCallId());
        entity.setIvrOutboundPlaceCallId(callDTO.getIvrOutboundPlaceCallId());
        entity.setLeadCaptureId(callDTO.getLeadCaptureId());

        return entity;
    }
}
