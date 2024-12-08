package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lead_salesrep_map")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadSalesrepMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadSalesrepMappingId;

    private Long salesrpDetailsId;

    private Long leadCaptureId;

    @JsonIgnore
    private String createdBy;

    @JsonIgnore
    private String updatedBy;

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

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
