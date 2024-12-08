package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Set;

@Data
public class CoreAcademicCareerDto {

    private Long academicCareerId;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[^\\s]+$", message = "Name should not contain spaces")
    private String name;
    @NotBlank(message = "Some description should be provided")
    private String description;
    private Status status;
    private Set<CoreAcademicProgramDto> coreAcademicPrograms;
}
