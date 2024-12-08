package in.co.srdt.entity.coresetup;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "core_salesrp_lead_last_assigned")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreSalesrpLeadLastAssigned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreSalesrpLeadLastAssignedId;

    private Long prioritySequence;
}
