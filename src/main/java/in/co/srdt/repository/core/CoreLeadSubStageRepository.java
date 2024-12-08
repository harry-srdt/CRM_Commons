package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreLeadSubStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreLeadSubStageRepository extends JpaRepository<CoreLeadSubStage,Long> {
}
