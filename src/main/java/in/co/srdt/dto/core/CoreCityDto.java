package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CoreCityDto {

   private Long coreCityId;
   private Long coreStateId;
   @Column(name = "name", length = 50, nullable = false)
   @NotBlank(message = "Name is required")
   private String name;
   private Status status;
}
