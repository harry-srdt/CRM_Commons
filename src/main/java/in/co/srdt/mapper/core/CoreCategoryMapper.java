package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreCategoryDto;
import in.co.srdt.entity.coresetup.CoreCategory;
import org.springframework.stereotype.Component;

@Component
public class CoreCategoryMapper {

    public CoreCategoryDto toDto(CoreCategory entity){
        if (entity==null)
            return null;
        CoreCategoryDto dto = new CoreCategoryDto();
        dto.setCategoryId(entity.getCategoryId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CoreCategory toEntity(CoreCategoryDto dto){
        if (dto==null)
            return null;
        CoreCategory entity = new CoreCategory();
        entity.setCategoryId(dto.getCategoryId());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
