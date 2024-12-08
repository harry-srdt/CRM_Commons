package in.co.srdt.dto.salesrep;

import lombok.Data;

@Data
public class CoreSalesrepDetailsDTO {

    private Long salesrpDetailsId;
    private String username;
    private String fullName;
    private String email;
    private String countryCode;
    private String phone;
    private Long managerId;
    private String userType;
}
