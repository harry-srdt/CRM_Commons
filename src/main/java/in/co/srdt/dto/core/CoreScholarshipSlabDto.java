package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CoreScholarshipSlabDto {
    private Long scholarshipSlabId;
    private Long scholarshipSchemeId;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[^\\s]+$", message = "Name should not contain spaces")
    private String name;
    private String displayName;
    private Status status;
    private String schemeName;
    private String CategoryName;
}
