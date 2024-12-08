package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreGeneralVariableValuesDto;
import in.co.srdt.entity.coresetup.CoreGeneralVariableValues;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CoreGeneralVariableValuesMapper {


    public CoreGeneralVariableValuesDto toDto(CoreGeneralVariableValues variableValues){
        if (variableValues==null)
            return null;

        CoreGeneralVariableValuesDto dto = new CoreGeneralVariableValuesDto();
        dto.setCoreGeneralVariableValuesId(variableValues.getCoreGeneralVariableValuesId());
        dto.setName(variableValues.getName());
        dto.setDisplayName(variableValues.getDisplayName());
        dto.setSqlText(variableValues.getSqlText());
        dto.setCoreWhatsappTemplatesVariableId(dto.getCoreWhatsappTemplatesVariableId());
        return dto;
    }

    public CoreGeneralVariableValues toEntity(CoreGeneralVariableValuesDto variableValuesDto){
        if (variableValuesDto==null)
            return null;

        CoreGeneralVariableValues entity = new CoreGeneralVariableValues();
        entity.setCoreGeneralVariableValuesId(variableValuesDto.getCoreGeneralVariableValuesId());
        entity.setName(variableValuesDto.getName());
        entity.setDisplayName(variableValuesDto.getDisplayName());
        entity.setSqlText(variableValuesDto.getSqlText());
        return entity;
    }
}
