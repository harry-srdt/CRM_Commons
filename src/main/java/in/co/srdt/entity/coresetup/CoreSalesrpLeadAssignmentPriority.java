package in.co.srdt.entity.coresetup;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "core_salesrp_lead_assignment_priority")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreSalesrpLeadAssignmentPriority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreSalesrpLeadAssignmentPriorityId;

    private Long managerId;

    private Long prioritySequence;
}
