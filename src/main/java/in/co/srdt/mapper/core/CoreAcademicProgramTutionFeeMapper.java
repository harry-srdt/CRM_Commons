package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreAcademicProgramTutionFeeDto;
import in.co.srdt.entity.coresetup.CoreAcademicCareer;
import in.co.srdt.entity.coresetup.CoreAcademicProgram;
import in.co.srdt.entity.coresetup.CoreAcademicProgramTutionFee;
import org.springframework.stereotype.Component;

@Component
public class CoreAcademicProgramTutionFeeMapper {

    public CoreAcademicProgramTutionFeeDto toDto(CoreAcademicProgramTutionFee entity) {
        if (entity == null) {
            return null;
        }
        CoreAcademicProgram academicProgram = entity.getCoreAcademicProgram();
        CoreAcademicCareer academicCareer = academicProgram.getCoreAcademicCareer();
        CoreAcademicProgramTutionFeeDto dto = new CoreAcademicProgramTutionFeeDto();
        dto.setAcademicProgramTuitionFeeId(entity.getAcademicProgramTutionFeeId());
        dto.setAcademicProgramId(entity.getCoreAcademicProgram() != null ? entity.getCoreAcademicProgram().getAcademicProgramId() : null);
        dto.setFeeAmount(entity.getFeeAmount());
        dto.setAcademicProgramName(academicProgram.getName());
        dto.setAcademicCareerName(academicCareer.getName());
        dto.setEffectiveDate(entity.getEffectiveDate());

        return dto;
    }

    public CoreAcademicProgramTutionFee toEntity(CoreAcademicProgramTutionFeeDto dto, CoreAcademicProgram coreAcademicProgram) {
        if (dto == null) {
            return null;
        }
        CoreAcademicProgramTutionFee entity = new CoreAcademicProgramTutionFee();
        entity.setAcademicProgramTutionFeeId(dto.getAcademicProgramTuitionFeeId());
        entity.setCoreAcademicProgram(coreAcademicProgram);
        entity.setFeeAmount(dto.getFeeAmount());
        entity.setEffectiveDate(dto.getEffectiveDate());

        return entity;
    }
}
