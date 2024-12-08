package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadScheduledTask;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "core_salesrp_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreSalesRepDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salesrpDetailsId;

    @Column(length = 50,unique = true)
    private String username;
    private String fullName;
    private String email;
    private String countryCode;
    private Long managerId;

    @OneToMany(mappedBy = "salesrpDetails", cascade = CascadeType.ALL)
    private List<LeadScheduledTask> assignedTasks;

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
