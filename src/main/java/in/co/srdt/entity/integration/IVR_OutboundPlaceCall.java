package in.co.srdt.entity.integration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ivr_outbound_place_call")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IVR_OutboundPlaceCall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ivrOutboundPlaceCallId;
    private String message;
    private String status;
    private String callId;
    private String refId;
    private LocalDateTime createdAt;
    private Long leadCaptureId;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
