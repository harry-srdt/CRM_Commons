package in.co.srdt.dto.core;

import in.co.srdt.enums.TemplateType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CoreWhatsappTemplatesDto {

    private Long coreWhatsappTemplatesId;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    private CoreWhatsappMediaAttachmentDto coreWhatsappMediaAttachmentDto;

    @NotBlank(message = "Display name cannot be blank")
    @Size(max = 100, message = "Display name cannot exceed 100 characters")
    private String displayName;

    @NotNull(message = "Template type cannot be null")
    private TemplateType templateType;

    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotNull(message = "Variable usage status cannot be null")
    private Boolean isVariableUsed;

    @NotNull(message = "Media attachment status cannot be null")
    private Boolean isMediaAttached;

    private String vendorTemplateId;
}
