package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreLeadStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreLeadStageRepository extends JpaRepository<CoreLeadStage,Long> {

    @Query("SELECT cls.displayName FROM CoreLeadStage cls " +
            "WHERE cls.leadStageId = :leadStageId " +
            "ORDER BY cls.createdAt DESC")
    String findLatestDisplayNameByLeadStageId(@Param("leadStageId") Long leadStageId);

    @Query("SELECT cls.name FROM CoreLeadStage cls WHERE cls.leadStageId = :leadStageId")
    String findNameById(@Param("leadStageId") Long leadStageId);
}
