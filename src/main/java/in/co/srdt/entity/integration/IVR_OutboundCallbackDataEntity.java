package in.co.srdt.entity.integration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ivr_outbound_callback_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IVR_OutboundCallbackDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ivrOutboundCallbackDataId;

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
