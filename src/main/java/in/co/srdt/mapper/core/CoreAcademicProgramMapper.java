package in.co.srdt.mapper.core;


import in.co.srdt.dto.core.CoreAcademicProgramDto;
import in.co.srdt.entity.coresetup.CoreAcademicProgram;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CoreAcademicProgramMapper {

    public CoreAcademicProgramDto toDto(CoreAcademicProgram program) {
        if (program == null) {
            return null;
        }
        CoreAcademicProgramDto dto = new CoreAcademicProgramDto();
        dto.setAcademicProgramId(program.getAcademicProgramId());
        dto.setAcademicCareerName(program.getCoreAcademicCareer().getName());
        dto.setAcademicCareerId(program.getCoreAcademicCareer().getAcademicCareerId());
        dto.setName(program.getName());
        dto.setDescription(program.getDescription());
        dto.setStatus(program.getStatus());

        return dto;
    }

    public CoreAcademicProgram toEntity(CoreAcademicProgramDto dto) {
        if (dto == null) {
            return null;
        }
        CoreAcademicProgram program = new CoreAcademicProgram();
        program.setAcademicProgramId(dto.getAcademicProgramId());
        program.setName(dto.getName());
        program.setDescription(dto.getDescription());
        program.setStatus(dto.getStatus());
        return program;
    }

}
