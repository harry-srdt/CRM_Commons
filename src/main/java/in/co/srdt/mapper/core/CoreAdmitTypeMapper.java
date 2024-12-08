package in.co.srdt.mapper.core;


import in.co.srdt.dto.core.CoreAdmitTypeDto;
import in.co.srdt.entity.coresetup.CoreAdmitType;
import org.springframework.stereotype.Component;

@Component
public class CoreAdmitTypeMapper {

    public CoreAdmitType toEntity(CoreAdmitTypeDto coreAdmitTypeDto) {
        CoreAdmitType coreAdmitType = new CoreAdmitType();
        coreAdmitType.setAdmitTypeId(coreAdmitTypeDto.getAdmitTypeId());
        coreAdmitType.setName(coreAdmitTypeDto.getName());
        coreAdmitType.setDescription(coreAdmitTypeDto.getDescription());
        coreAdmitType.setStatus(coreAdmitTypeDto.getStatus());
        return coreAdmitType;
    }

    public CoreAdmitTypeDto toDto(CoreAdmitType coreAdmitType) {
        CoreAdmitTypeDto coreAdmitTypeDto = new CoreAdmitTypeDto();
        coreAdmitTypeDto.setAdmitTypeId(coreAdmitType.getAdmitTypeId());
        coreAdmitTypeDto.setName(coreAdmitType.getName());
        coreAdmitTypeDto.setDescription(coreAdmitType.getDescription());
        coreAdmitTypeDto.setStatus(coreAdmitType.getStatus());
        return coreAdmitTypeDto;
    }
}
