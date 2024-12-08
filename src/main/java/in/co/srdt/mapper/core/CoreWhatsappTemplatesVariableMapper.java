package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreWhatsappTemplatesVariableDto;
import in.co.srdt.entity.coresetup.CoreGeneralVariableValues;
import in.co.srdt.entity.coresetup.CoreWhatsappTemplates;
import in.co.srdt.entity.coresetup.CoreWhatsappTemplatesVariable;
import in.co.srdt.exception.lead.ResourceNotFoundException;
import in.co.srdt.repository.core.CoreGeneralVariableValuesRepository;
import in.co.srdt.repository.core.CoreWhatsappTemplatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CoreWhatsappTemplatesVariableMapper {

    private final CoreWhatsappTemplatesRepository templatesRepository;
    private final CoreGeneralVariableValuesRepository valuesRepository;

    public CoreWhatsappTemplatesVariableDto toDto(CoreWhatsappTemplatesVariable templatesVariable){
        if (templatesVariable==null)
            return null;
        CoreWhatsappTemplatesVariableDto dto = new CoreWhatsappTemplatesVariableDto();
        dto.setWhatsappTemplatesId(templatesVariable.getWhatsappTemplates()!=null?templatesVariable.getWhatsappTemplates().getCoreWhatsappTemplatesId():null);
        dto.setSequence(templatesVariable.getSequence());
        dto.setGeneralVariableValuesId(templatesVariable.getGeneralVariableValues()!=null?templatesVariable.getGeneralVariableValues().getCoreGeneralVariableValuesId():null);
        dto.setCoreWhatsappTemplatesVariableId(templatesVariable.getCoreWhatsappTemplatesVariableId());
        return dto;
    }

    public CoreWhatsappTemplatesVariable toEntity(CoreWhatsappTemplatesVariableDto variableDto){
        if (variableDto==null)
            return null;

        CoreWhatsappTemplatesVariable entity = new CoreWhatsappTemplatesVariable();

        CoreWhatsappTemplates whatsappTemplates = templatesRepository
                .findById(variableDto
                        .getWhatsappTemplatesId())
                .orElseThrow(()->new ResourceNotFoundException("WhatsApp Template NOt found with this id : " + variableDto.getWhatsappTemplatesId()));

        entity.setWhatsappTemplates(whatsappTemplates);

        entity.setSequence(variableDto.getSequence());

        CoreGeneralVariableValues variableValues = valuesRepository
                .findById(variableDto
                        .getGeneralVariableValuesId())
                .orElseThrow(()->new ResourceNotFoundException("General Variable Values NOt found with this id : " + variableDto.getGeneralVariableValuesId()));

        entity.setGeneralVariableValues(variableValues);

        return entity;
    }
}
