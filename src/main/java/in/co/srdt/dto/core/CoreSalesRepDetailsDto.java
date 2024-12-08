package in.co.srdt.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CoreSalesRepDetailsDto {

    private Long salesrpDetailsId;
    @NotBlank(message = "Name can not be blank")
    private String username;
    @NotNull
    private String fullName;
    @Email
    @NotNull
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String countryCode;
}
