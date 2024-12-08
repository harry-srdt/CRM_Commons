package in.co.srdt.dto.lead;

import in.co.srdt.enums.AddressType;
import lombok.Data;

@Data
public class LeadAddressDetailsDTO {

    private Long leadAddressDetailsId;
    private Long leadCaptureId;
    private AddressType addressType;
    private String country;
    private Long coreStateId;
    private Long coreCityId;
    private String address;
    private String stateName;
    private String cityName;
}
