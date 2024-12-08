package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreSalesRepDetailsDto;
import in.co.srdt.entity.coresetup.CoreSalesRepDetails;
import org.springframework.stereotype.Component;

@Component
public class CoreSalesRepDetailsMapper {

    public CoreSalesRepDetailsDto toDto(CoreSalesRepDetails salesRepDetails){
        if (salesRepDetails==null)
            return null;

        CoreSalesRepDetailsDto dto =  new CoreSalesRepDetailsDto();
        dto.setSalesrpDetailsId(salesRepDetails.getSalesrpDetailsId());
        dto.setEmail(salesRepDetails.getEmail());
        dto.setUsername(salesRepDetails.getUsername());
        dto.setCountryCode(salesRepDetails.getCountryCode());
        dto.setFullName(salesRepDetails.getFullName());
        return dto;
    }

    public CoreSalesRepDetails toEntity(CoreSalesRepDetailsDto salesRepDetailsDto){
        if (salesRepDetailsDto==null)
            return null;

        CoreSalesRepDetails entity = new CoreSalesRepDetails();
        entity.setSalesrpDetailsId(salesRepDetailsDto.getSalesrpDetailsId());
        entity.setEmail(salesRepDetailsDto.getEmail());
        entity.setUsername(salesRepDetailsDto.getUsername());
        entity.setCountryCode(salesRepDetailsDto.getCountryCode());
        entity.setFullName(salesRepDetailsDto.getFullName());
        return entity;
    }
}
