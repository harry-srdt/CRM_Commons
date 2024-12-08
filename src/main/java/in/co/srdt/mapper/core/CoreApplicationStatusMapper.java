package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreApplicationStatusDto;
import in.co.srdt.dto.lead.LeadApplicationStatusDTO;
import in.co.srdt.entity.coresetup.CoreApplicationStatus;
import in.co.srdt.mapper.lead.LeadApplicationStatusMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CoreApplicationStatusMapper {

    private final LeadApplicationStatusMapper leadApplicationStatusMapper;

    public CoreApplicationStatusDto toDto(CoreApplicationStatus applicationStatus){
        if (applicationStatus==null)
            return null;
        CoreApplicationStatusDto dto = new CoreApplicationStatusDto();
        dto.setCoreApplicationStatusId(applicationStatus.getCoreApplicationStatusId());
        dto.setName(applicationStatus.getName());
        dto.setDisplayName(applicationStatus.getDisplayName());
        dto.setStatus(applicationStatus.getStatus());

        if (applicationStatus.getLeadApplicationStatus() != null) {
            List<LeadApplicationStatusDTO> leadStatusDtos = applicationStatus.getLeadApplicationStatus().stream()
                    .map(leadApplicationStatusMapper::toDto)
                    .toList();
            dto.setLeadApplicationStatus(leadStatusDtos);
        }
        return dto;
    }

    public CoreApplicationStatus toEntity(CoreApplicationStatusDto dto) {
        if (dto == null)
            return null;
        CoreApplicationStatus applicationStatus = new CoreApplicationStatus();
        applicationStatus.setCoreApplicationStatusId(dto.getCoreApplicationStatusId());
        applicationStatus.setName(dto.getName());
        applicationStatus.setDisplayName(dto.getDisplayName());
        applicationStatus.setStatus(dto.getStatus());

        applicationStatus.setLeadApplicationStatus(dto
                .getLeadApplicationStatus()!=null?dto
                .getLeadApplicationStatus()
                .stream()
                .map(leadApplicationStatusMapper::toEntity).toList():new ArrayList<>());

        return applicationStatus;
    }

}
