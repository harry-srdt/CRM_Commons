package in.co.srdt.dto.core;

import lombok.Data;
import java.util.List;

@Data
public class CoreTaskCategoryDto {
    private Long categoryId;
    private String name;
    private List<CoreTaskTypeDto> coreTaskTypes;
}
