package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CoreTwelveResultStatusDto {

    private Long twelveMarkingSchemeId;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^\\S+$", message = "Name should not contain spaces")
    private String name;
    private String displayName;
    private Status status;

}
