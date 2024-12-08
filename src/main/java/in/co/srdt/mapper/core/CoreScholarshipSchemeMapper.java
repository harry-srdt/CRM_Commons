package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreScholarshipSchemeDto;
import in.co.srdt.entity.coresetup.CoreScholarshipCategory;
import in.co.srdt.entity.coresetup.CoreScholarshipScheme;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CoreScholarshipSchemeMapper {

    private final CoreScholarshipSlabMapper slabMapper;

    public CoreScholarshipSchemeDto toDto(CoreScholarshipScheme entity) {
        if (entity == null)
            return null;

        
        CoreScholarshipSchemeDto dto = new CoreScholarshipSchemeDto();
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setStatus(entity.getStatus());
        dto.setScholarshipSchemeId(entity.getScholarshipSchemeId());
        dto.setScholarshipCategoryId(entity.getScholarshipCategory().getScholarshipCategoryId());
        if (entity.getScholarshipSlabs() != null && !entity.getScholarshipSlabs().isEmpty()) {
            dto.setScholarshipSlabs(
                    entity.getScholarshipSlabs().stream()
                            .map(slabMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public CoreScholarshipScheme toEntity(CoreScholarshipSchemeDto dto) {
        if (dto == null)
            return null;
        CoreScholarshipScheme entity = new CoreScholarshipScheme();
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
        entity.setStatus(dto.getStatus());
        entity.setScholarshipSchemeId(dto.getScholarshipSchemeId());

        CoreScholarshipCategory category = new CoreScholarshipCategory();
        category.setScholarshipCategoryId(dto.getScholarshipCategoryId());
        entity.setScholarshipCategory(category);

        if (dto.getScholarshipSlabs() != null) {
            dto.getScholarshipSlabs().stream()
                    .map(slabMapper::toEntity)
                    .toList();
        }

        return entity;
    }
}
