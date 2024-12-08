package in.co.srdt.dto.core;

import in.co.srdt.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Core12thBoardDto {

    private Long core12thBoardId;
    @NotBlank(message = "Name can not be blank")
    @Pattern(regexp = "^\\S+$", message = "Name should not contain spaces")
    private String name;
    private Status status;
}
