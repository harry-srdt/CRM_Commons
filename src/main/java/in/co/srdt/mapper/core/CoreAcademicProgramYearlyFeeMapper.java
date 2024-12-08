package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreAcademicProgramYearlyFeeDto;
import in.co.srdt.entity.coresetup.CoreAcademicCareer;
import in.co.srdt.entity.coresetup.CoreAcademicProgram;
import in.co.srdt.entity.coresetup.CoreAcademicProgramYearlyFee;
import in.co.srdt.exception.core.CoreAcademicCareerNotFoundException;
import in.co.srdt.repository.core.CoreAcademicCareerRepository;
import in.co.srdt.repository.core.CoreAcademicProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CoreAcademicProgramYearlyFeeMapper {

    private final CoreAcademicProgramRepository academicProgramRepository;
    private final CoreAcademicCareerRepository academicCareerRepository;

    public CoreAcademicProgramYearlyFeeDto toDto(CoreAcademicProgramYearlyFee entity) {
        if (entity == null) {
            return null;
        }
        CoreAcademicProgram academicProgram = entity.getCoreAcademicProgram();
        CoreAcademicCareer academicCareer = academicProgram.getCoreAcademicCareer();
        CoreAcademicProgram program =  academicProgramRepository.findById(academicProgram.getAcademicProgramId())
                .orElseThrow(()->new CoreAcademicCareerNotFoundException("Academic Program not found with this id : " + academicProgram.getAcademicProgramId()));
        CoreAcademicCareer career =  academicCareerRepository.findById(academicCareer.getAcademicCareerId())
                .orElseThrow(()->new CoreAcademicCareerNotFoundException("Academic Career not found with this id : " + academicCareer.getAcademicCareerId()));
        CoreAcademicProgramYearlyFeeDto dto = new CoreAcademicProgramYearlyFeeDto();
        dto.setAcademicProgramYearlyFeeId(entity.getAcademicProgramYearlyFeeId());
        dto.setAcademicProgramId(entity.getCoreAcademicProgram().getAcademicProgramId());
        dto.setFeeAmount(entity.getFeeAmount());
        dto.setEffectiveDate(entity.getEffectiveDate());
        dto.setCoreAcademicProgramName(program.getName());
        dto.setCoreAcademicCareerName(career.getName());
        return dto;
    }

    public CoreAcademicProgramYearlyFee toEntity(CoreAcademicProgramYearlyFeeDto dto, CoreAcademicProgram coreAcademicProgram) {
        if (dto == null) {
            return null;
        }
        CoreAcademicProgramYearlyFee entity = new CoreAcademicProgramYearlyFee();
        entity.setAcademicProgramYearlyFeeId(dto.getAcademicProgramYearlyFeeId());
        entity.setAcademicProgramYearlyFeeId(dto.getAcademicProgramYearlyFeeId());
        entity.setCoreAcademicProgram(coreAcademicProgram);
        entity.setFeeAmount(dto.getFeeAmount());
        entity.setEffectiveDate(dto.getEffectiveDate());
        return entity;
    }
}
