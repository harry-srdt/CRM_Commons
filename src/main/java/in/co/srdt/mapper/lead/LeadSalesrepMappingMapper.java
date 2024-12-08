package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadSalesrepMappingDTO;
import in.co.srdt.entity.lead.LeadSalesrepMapping;
import org.springframework.stereotype.Component;

@Component
public class LeadSalesrepMappingMapper {

    public LeadSalesrepMappingDTO toDto(LeadSalesrepMapping leadSalesrepMapping) {
        if (leadSalesrepMapping == null)
            return null;

        LeadSalesrepMappingDTO dto = new LeadSalesrepMappingDTO();
        dto.setLeadSalesrepMappingId(leadSalesrepMapping.getLeadSalesrepMappingId());
        dto.setSalesrpDetailsId(leadSalesrepMapping.getSalesrpDetailsId());
        dto.setLeadCaptureId(leadSalesrepMapping.getLeadCaptureId());
        return dto;
    }

    public LeadSalesrepMapping toEntity(LeadSalesrepMappingDTO leadSalesrepMappingDTO) {
        if (leadSalesrepMappingDTO == null)
            return null;

        LeadSalesrepMapping entity = new LeadSalesrepMapping();
        entity.setLeadSalesrepMappingId(leadSalesrepMappingDTO.getLeadSalesrepMappingId());
        entity.setSalesrpDetailsId(leadSalesrepMappingDTO.getSalesrpDetailsId());
        entity.setLeadCaptureId(leadSalesrepMappingDTO.getLeadCaptureId());
        return entity;
    }
}
