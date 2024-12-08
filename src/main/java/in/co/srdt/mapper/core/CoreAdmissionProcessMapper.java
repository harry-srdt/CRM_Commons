package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreAdmissionProcessDto;
import in.co.srdt.entity.coresetup.CoreAdmissionProcess;
import org.springframework.stereotype.Component;

@Component
public class CoreAdmissionProcessMapper {

    public CoreAdmissionProcessDto toDto(CoreAdmissionProcess entity){
        if (entity==null)
            return null;
        CoreAdmissionProcessDto dto = new CoreAdmissionProcessDto();
        dto.setAdmissionProcessId(entity.getAdmissionProcessId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreAdmissionProcess toEntity(CoreAdmissionProcessDto dto){
        if (dto==null)
            return null;
        CoreAdmissionProcess entity = new CoreAdmissionProcess();
        entity.setAdmissionProcessId(dto.getAdmissionProcessId());
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
