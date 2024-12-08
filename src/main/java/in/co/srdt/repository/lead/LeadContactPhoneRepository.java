package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.entity.lead.LeadContactPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LeadContactPhoneRepository extends JpaRepository<LeadContactPhone,Long> {

    List<LeadContactPhone> findByLeadCapture(LeadCapture leadCaptureId);

    @Transactional
    @Modifying
    void deleteByLeadCapture(LeadCapture leadCapture);
}
