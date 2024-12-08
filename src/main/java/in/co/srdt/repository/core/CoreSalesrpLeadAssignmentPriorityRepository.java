package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreSalesrpLeadAssignmentPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreSalesrpLeadAssignmentPriorityRepository extends JpaRepository<CoreSalesrpLeadAssignmentPriority,Long> {

    @Query("Select a.managerId From CoreSalesrpLeadAssignmentPriority a Where a.prioritySequence=?1")
    public Long findManagerIdByPrioritySequence(Long prioritySequence);
}
