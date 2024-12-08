package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CoreStateDto {

    private Long coreStateId;
    @NotBlank(message = "State Code is mandatory")
    private String stateCode;
    @Column(name = "name", length = 50, nullable = false)
    @NotBlank(message = "Name is required")
    private String name;
    private Status status;
    private List<CoreCityDto> coreCity;
}
