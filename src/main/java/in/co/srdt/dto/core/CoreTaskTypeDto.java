package in.co.srdt.dto.core;

import lombok.Data;

@Data
public class CoreTaskTypeDto {
    private Long coreTaskTypeId;
    private String name;
    private CoreTaskCategoryDto categoryDto;
}
