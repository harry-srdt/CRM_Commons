package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreSalesrpLeadLastAssigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CoreSalesrpLeadLastAssignedRepository extends JpaRepository<CoreSalesrpLeadLastAssigned, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE CoreSalesrpLeadLastAssigned c SET c.prioritySequence = :newPrioritySequence WHERE c.coreSalesrpLeadLastAssignedId = 1")
    void updateNewPrioritySequence(@Param("newPrioritySequence") Long newPrioritySequence);

}
