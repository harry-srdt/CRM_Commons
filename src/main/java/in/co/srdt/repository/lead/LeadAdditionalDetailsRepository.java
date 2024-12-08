package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadAdditionalDetails;
import in.co.srdt.entity.lead.LeadCapture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeadAdditionalDetailsRepository extends JpaRepository<LeadAdditionalDetails,Long> {

    Optional<LeadAdditionalDetails> findByLeadCapture(LeadCapture leadCaptureId);
}
