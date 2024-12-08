package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CoreLeadActionsDto {

    private Long coreLeadActionsId;
    @NotNull
    private String name;
    @NotNull
    private String displayName;
    private String iconName;
    private Status status;
}
