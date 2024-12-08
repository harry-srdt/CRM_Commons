package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreAcademicProgramDto {

    private Long academicProgramId;
    private Long academicCareerId;
    private String academicCareerName;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^\\S+$", message = "Name should not contain spaces")
    private String name;
    @NotBlank(message = "Some description should be provided")
    private String description;
    private Status status;

}
