package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadActionsPerformed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadActionsPerformedRepository extends JpaRepository<LeadActionsPerformed,Long> {

    @Query("SELECT la FROM LeadActionsPerformed la WHERE la.leadCapture.id = :leadCaptureId order by la.createdAt")
    List<LeadActionsPerformed> findAllByLeadCaptureId(@Param("leadCaptureId") long leadCaptureId);

 /*   @Query(value = "select * from lead_actions_performed where lead_capture_id=:leadCaptureId and core_lead_actions_id=:coreLeadActionsId",nativeQuery = true)
    List<Object> findByLeadCaptureAndCoreLeadActions(
            @Param("leadCaptureId") Long leadCaptureId,
            @Param("coreLeadActionsId") Long coreLeadActionsId);
*/



}
