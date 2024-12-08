package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadStageRepository extends JpaRepository<LeadStage,Long> {
}
