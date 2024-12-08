package in.co.srdt.mapper.core;


import in.co.srdt.dto.core.CoreAcademicCareerDto;
import in.co.srdt.dto.core.CoreAcademicProgramDto;
import in.co.srdt.entity.coresetup.CoreAcademicCareer;
import in.co.srdt.entity.coresetup.CoreAcademicProgram;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CoreAcademicCareerMapper {

    private final CoreAcademicProgramMapper coreAcademicProgramMapper;

    public CoreAcademicCareerDto toDto(CoreAcademicCareer coreAcademicCareer) {
        if (coreAcademicCareer == null)
            return null;
        CoreAcademicCareerDto dto = new CoreAcademicCareerDto();
        dto.setAcademicCareerId(coreAcademicCareer.getAcademicCareerId());
        dto.setName(coreAcademicCareer.getName());
        dto.setDescription(coreAcademicCareer.getDescription());
        dto.setStatus(coreAcademicCareer.getStatus());

        if (coreAcademicCareer.getCoreAcademicPrograms() != null) {
            Set<CoreAcademicProgramDto> programDtos = coreAcademicCareer.getCoreAcademicPrograms().stream()
                    .map(coreAcademicProgramMapper::toDto)
                    .collect(Collectors.toSet());
            dto.setCoreAcademicPrograms(programDtos);
        }

        return dto;
    }

    public CoreAcademicCareer toEntity(CoreAcademicCareerDto dto) {
        if (dto == null) {
            return null;
        }
        CoreAcademicCareer career = new CoreAcademicCareer();
        career.setAcademicCareerId(dto.getAcademicCareerId());
        career.setName(dto.getName());
        career.setDescription(dto.getDescription());
        career.setStatus(dto.getStatus());

        if (dto.getCoreAcademicPrograms() != null) {
            Set<CoreAcademicProgram> programs = dto.getCoreAcademicPrograms().stream()
                    .map(coreAcademicProgramMapper::toEntity)
                    .collect(Collectors.toSet());
            career.setCoreAcademicPrograms(programs);
        }

        return career;
    }

}
