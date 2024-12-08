package in.co.srdt.entity.salesrep;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "core_salesrp_details")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreSalesrepDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salesrpDetailsId;

    private String username;
    private String fullName;
    private String email;
    private String countryCode;
    private String phone;
    private Long managerId;
    private String userType;

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
