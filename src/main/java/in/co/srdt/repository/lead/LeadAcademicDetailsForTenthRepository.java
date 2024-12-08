package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadAcademicDetailsForTenth;
import in.co.srdt.entity.lead.LeadCapture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LeadAcademicDetailsForTenthRepository extends JpaRepository<LeadAcademicDetailsForTenth,Long> {

    Optional<LeadAcademicDetailsForTenth> findByLeadCapture(LeadCapture leadCaptureId);
    @Transactional
    @Modifying
    void deleteByLeadCapture(LeadCapture leadCapture);
}
