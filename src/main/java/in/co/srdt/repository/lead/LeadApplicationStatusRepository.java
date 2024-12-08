package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadApplicationStatusRepository extends JpaRepository<LeadApplicationStatus,Long> {
}
