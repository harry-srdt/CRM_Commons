package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreTwelveResultStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreTwelveResultStatusRepository extends JpaRepository<CoreTwelveResultStatus,Long> {
}
