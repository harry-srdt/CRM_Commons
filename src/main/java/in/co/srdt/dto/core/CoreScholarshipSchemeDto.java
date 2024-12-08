package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class CoreScholarshipSchemeDto {
    private Long scholarshipSchemeId;
    private Long scholarshipCategoryId;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[^\\s]+$", message = "Name should not contain spaces")
    private String name;
    @NotBlank(message = "Display Name is required")
    private String displayName;
    private Status status;
    private List<CoreScholarshipSlabDto> scholarshipSlabs;
}
