package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreApplicationStatusRepository extends JpaRepository<CoreApplicationStatus,Long> {
}
