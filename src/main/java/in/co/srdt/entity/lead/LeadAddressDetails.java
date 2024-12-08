package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.CoreCity;
import in.co.srdt.entity.coresetup.CoreState;
import in.co.srdt.enums.AddressType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lead_address_details")
public class LeadAddressDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadAddressDetailsId;

    @ManyToOne
    @JoinColumn(name = "lead_capture_id")
    private LeadCapture leadCapture;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Column(length = 20)
    private String country;

    @ManyToOne
    @JoinColumn(name = "core_state_id")
    private CoreState coreState;

    @ManyToOne
    @JoinColumn(name = "core_city_id")
    private CoreCity coreCity;

    @Column(length = 500)
    private String address;

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    private String createdBy;

    @JsonIgnore
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
