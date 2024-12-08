package in.co.srdt.dto.integration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonApiResponse {
    private String status;
    private String message;
}
