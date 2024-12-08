package in.co.srdt.repository.core;


import in.co.srdt.entity.coresetup.CoreInstalmentStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreInstalmentStageRepository extends JpaRepository<CoreInstalmentStage,Long> {
    boolean existsByName(String name);
}
