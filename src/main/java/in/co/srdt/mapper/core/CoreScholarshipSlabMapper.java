package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreScholarshipSlabDto;
import in.co.srdt.entity.coresetup.CoreScholarshipCategory;
import in.co.srdt.entity.coresetup.CoreScholarshipScheme;
import in.co.srdt.entity.coresetup.CoreScholarshipSlab;
import org.springframework.stereotype.Component;

@Component
public class CoreScholarshipSlabMapper {

    public CoreScholarshipSlabDto toDto(CoreScholarshipSlab entity) {
        if (entity == null) {
            return null;
        }
        CoreScholarshipScheme scheme = entity.getScholarshipScheme();
        CoreScholarshipCategory category = scheme.getScholarshipCategory();
        CoreScholarshipSlabDto dto = new CoreScholarshipSlabDto();
        dto.setScholarshipSlabId(entity.getScholarshipSlabId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setStatus(entity.getStatus());
        dto.setSchemeName(scheme.getName());
        dto.setCategoryName(category.getName());
        dto.setScholarshipSchemeId(entity.getScholarshipScheme().getScholarshipSchemeId());
        return dto;
    }

    public CoreScholarshipSlab toEntity(CoreScholarshipSlabDto dto) {
        if (dto == null) {
            return null;
        }
        CoreScholarshipSlab entity = new CoreScholarshipSlab();
        entity.setScholarshipSlabId(dto.getScholarshipSlabId());
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
        entity.setStatus(dto.getStatus());
        CoreScholarshipScheme scheme = new CoreScholarshipScheme();
        scheme.setScholarshipSchemeId(dto.getScholarshipSchemeId());
        entity.setScholarshipScheme(scheme);
        return entity;
    }
}
