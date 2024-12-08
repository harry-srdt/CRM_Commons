package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreStateDto;
import in.co.srdt.entity.coresetup.CoreState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CoreStateMapper {

    private final CoreCityMapper coreCityMapper;

    public CoreStateDto toDto(CoreState coreState) {
        if (coreState == null) {
            return null;
        }

        CoreStateDto dto = new CoreStateDto();
        dto.setCoreStateId(coreState.getCoreStateId());
        dto.setStateCode(coreState.getStateCode());
        dto.setName(coreState.getName());
        dto.setStatus(coreState.getStatus());

        if (coreState.getCoreCity() != null) {
            dto.setCoreCity(coreState.getCoreCity().stream()
                    .map(coreCityMapper::toDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public  CoreState toEntity(CoreStateDto dto) {
        if (dto == null) {
            return null;
        }
        CoreState coreState = new CoreState();
        coreState.setCoreStateId(dto.getCoreStateId());
        coreState.setStateCode(dto.getStateCode());
        coreState.setName(dto.getName());
        coreState.setStatus(dto.getStatus());

        if (dto.getCoreCity() != null) {
            coreState.setCoreCity(dto.getCoreCity().stream()
                    .map(coreCityMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return coreState;
    }
}
