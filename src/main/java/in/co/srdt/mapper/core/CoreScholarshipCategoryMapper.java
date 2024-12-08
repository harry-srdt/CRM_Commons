package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreScholarshipCategoryDto;
import in.co.srdt.entity.coresetup.CoreScholarshipCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CoreScholarshipCategoryMapper {

    private final CoreScholarshipSchemeMapper schemeMapper;

    public CoreScholarshipCategoryDto toDto(CoreScholarshipCategory entity) {
        if (entity == null) {
            return null;
        }
        CoreScholarshipCategoryDto dto = new CoreScholarshipCategoryDto();
        dto.setScholarshipCategoryId(entity.getScholarshipCategoryId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setStatus(entity.getStatus());

        dto.setScholarshipSchemes(
                entity.getScholarshipSchemes() == null ?
                        new ArrayList<>() :
                        entity.getScholarshipSchemes().stream()
                                .map(schemeMapper::toDto)
                                .collect(Collectors.toList())
        );
        return dto;
    }

    public CoreScholarshipCategoryDto toDtoExcludingScholarshipScheme(CoreScholarshipCategory entity) {
        if (entity == null) {
            return null;
        }
        CoreScholarshipCategoryDto dto = new CoreScholarshipCategoryDto();
        dto.setScholarshipCategoryId(entity.getScholarshipCategoryId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreScholarshipCategory toEntity(CoreScholarshipCategoryDto dto) {
        if (dto == null) {
            return null;
        }
        CoreScholarshipCategory entity = new CoreScholarshipCategory();
        entity.setScholarshipCategoryId(dto.getScholarshipCategoryId());
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
        entity.setStatus(dto.getStatus());

        entity.setScholarshipSchemes(
                dto.getScholarshipSchemes() == null ?
                        new ArrayList<>() :
                        dto.getScholarshipSchemes().stream()
                                .map(schemeMapper::toEntity)
                                .collect(Collectors.toList())
        );
        return entity;
    }

}
