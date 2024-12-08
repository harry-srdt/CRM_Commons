package in.co.srdt.dto.integration;

import lombok.Data;

@Data
public class OutboundCallbackDataDTO {

    private Long outboundCallbackDataId;
    private String starttime;
    private String callid;
    private String emp_phone;
    private String clicktocalldid;
    private String callto;
    private String dialstatus;
    private String filename;
    private String direction;
    private String endtime;
    private String disconnectedby;
    private String answeredtime;
    private String groupname;
    private String agentname;
    private String refid;

}
