package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadAcademicDetailsUG;
import in.co.srdt.entity.lead.LeadCapture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeadAcademicDetailsUGRepository extends JpaRepository<LeadAcademicDetailsUG, Long> {

    Optional<LeadAcademicDetailsUG> findByLeadCapture(LeadCapture leadCaptureId);
}
