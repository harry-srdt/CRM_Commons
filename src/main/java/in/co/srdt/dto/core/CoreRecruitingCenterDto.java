package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CoreRecruitingCenterDto {

    private Long recruitingCenterId;
    @NotBlank(message = "Name can not be blank")
    @Pattern(regexp = "^\\S+$", message = "Name should not contain spaces")
    private String name;
    @NotBlank(message = "Some description should be provided")
    private String description;
    private Status status;
}
