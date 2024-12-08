package in.co.srdt.mapper.integration;


import in.co.srdt.dto.integration.OutboundCallbackDataDTO;
import in.co.srdt.entity.integration.IVR_OutboundCallbackDataEntity;
import org.springframework.stereotype.Component;

@Component
public class IVR_OutboundCallbackDataMapper {

    public OutboundCallbackDataDTO toDto(IVR_OutboundCallbackDataEntity dataEntity){
        if(dataEntity==null)
            return null;

        OutboundCallbackDataDTO model = new OutboundCallbackDataDTO();
        model.setOutboundCallbackDataId(dataEntity.getIvrOutboundCallbackDataId());
        model.setAgentname(dataEntity.getAgentname());
        model.setAnsweredtime(dataEntity.getAnsweredtime());
        model.setCallid(dataEntity.getCallid());
        model.setCallto(dataEntity.getCallto());
        model.setDialstatus(dataEntity.getDialstatus());
        model.setClicktocalldid(dataEntity.getClicktocalldid());
        model.setAgentname(dataEntity.getAgentname());
        model.setDirection(dataEntity.getDirection());
        model.setEndtime(dataEntity.getEndtime());
        model.setFilename(dataEntity.getFilename());
        model.setEmp_phone(dataEntity.getEmp_phone());
        model.setDisconnectedby(dataEntity.getDisconnectedby());
        model.setRefid(dataEntity.getRefid());
        model.setGroupname(dataEntity.getGroupname());
        model.setStarttime(dataEntity.getStarttime());

        return model;
    }

    public IVR_OutboundCallbackDataEntity toEntity(OutboundCallbackDataDTO callbackData){
        if (callbackData==null)
            return null;

        IVR_OutboundCallbackDataEntity entity = new IVR_OutboundCallbackDataEntity();

        entity.setIvrOutboundCallbackDataId(callbackData.getOutboundCallbackDataId());
        entity.setAgentname(callbackData.getAgentname());
        entity.setAnsweredtime(callbackData.getAnsweredtime());
        entity.setCallid(callbackData.getCallid());
        entity.setCallto(callbackData.getCallto());
        entity.setDialstatus(callbackData.getDialstatus());
        entity.setClicktocalldid(callbackData.getClicktocalldid());
        entity.setAgentname(callbackData.getAgentname());
        entity.setDirection(callbackData.getDirection());
        entity.setEndtime(callbackData.getEndtime());
        entity.setFilename(callbackData.getFilename());
        entity.setEmp_phone(callbackData.getEmp_phone());
        entity.setDisconnectedby(callbackData.getDisconnectedby());
        entity.setRefid(callbackData.getRefid());
        entity.setGroupname(callbackData.getGroupname());
        entity.setStarttime(callbackData.getStarttime());

        return entity;
    }
}
