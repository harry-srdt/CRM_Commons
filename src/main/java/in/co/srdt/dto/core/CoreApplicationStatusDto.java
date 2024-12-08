package in.co.srdt.dto.core;

import in.co.srdt.dto.lead.LeadApplicationStatusDTO;
import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CoreApplicationStatusDto {

    private Long coreApplicationStatusId;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^\\S+$", message = "Name should not contain spaces")
    private String name;
    private String displayName;
    private Status status;
    private List<LeadApplicationStatusDTO> leadApplicationStatus = new ArrayList<>();
}
