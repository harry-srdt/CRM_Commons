package in.co.srdt.mapper.salesrep;

import in.co.srdt.dto.salesrep.CoreSalesrepDetailsDTO;
import in.co.srdt.entity.salesrep.CoreSalesrepDetails;
import org.springframework.stereotype.Component;

@Component
public class CoreSalesrepDetailsMapper {

    public CoreSalesrepDetailsDTO toDto(CoreSalesrepDetails salesrepDetails){
        if (salesrepDetails==null)
            return null;

        CoreSalesrepDetailsDTO dto = new CoreSalesrepDetailsDTO();

        dto.setSalesrpDetailsId(salesrepDetails.getSalesrpDetailsId());
        dto.setEmail(salesrepDetails.getEmail());
        dto.setPhone(salesrepDetails.getPhone());
        dto.setUsername(salesrepDetails.getUsername());
        dto.setFullName(salesrepDetails.getFullName());
        dto.setCountryCode(salesrepDetails.getCountryCode());
        dto.setManagerId(salesrepDetails.getManagerId());
        dto.setUserType(salesrepDetails.getUserType());

        return dto;
    }

    public CoreSalesrepDetails toEntity(CoreSalesrepDetailsDTO salesrepDetailsDTO){
        if (salesrepDetailsDTO==null)
            return null;

        CoreSalesrepDetails entity = new CoreSalesrepDetails();

        entity.setSalesrpDetailsId(salesrepDetailsDTO.getSalesrpDetailsId());
        entity.setEmail(salesrepDetailsDTO.getEmail());
        entity.setPhone(salesrepDetailsDTO.getPhone());
        entity.setUsername(salesrepDetailsDTO.getUsername());
        entity.setFullName(salesrepDetailsDTO.getFullName());
        entity.setCountryCode(salesrepDetailsDTO.getCountryCode());
        entity.setManagerId(salesrepDetailsDTO.getManagerId());
        entity.setUserType(salesrepDetailsDTO.getUserType());

        return entity;
    }
}
