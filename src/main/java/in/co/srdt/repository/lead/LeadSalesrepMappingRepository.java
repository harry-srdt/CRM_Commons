package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadSalesrepMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadSalesrepMappingRepository extends JpaRepository<LeadSalesrepMapping,Long> {

    LeadSalesrepMapping findByLeadCaptureId(Long leadCaptureId);

}
