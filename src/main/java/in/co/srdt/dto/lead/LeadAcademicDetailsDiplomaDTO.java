package in.co.srdt.dto.lead;

import in.co.srdt.enums.ResultStatus;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class LeadAcademicDetailsDiplomaDTO {

    private Long academicDetailsDiplomaId;
    private Long leadCaptureId;
    private String school;
    private String diplomaBoard;
    private ResultStatus resultStatus;
    private String marks;

    @Data
    @Component
    public static class LeadActivityHistoryDTO {

        private String dialStatus;
        private String direction;
        private String fileName;
        private String startTime;
        private String answeredTime;

    }
}
