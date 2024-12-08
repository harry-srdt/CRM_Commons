package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CoreInstalmentTypeDto {

    private Long instalmentTypeId;
    @NotBlank(message = "Name can not be blank")
    @Pattern(regexp = "^\\S+$", message = "Name should not contain spaces")
    private String name;
    private String displayName;
    private Status status;
}
