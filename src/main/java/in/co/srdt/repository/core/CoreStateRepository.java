package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreState;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CoreStateRepository extends JpaRepository<CoreState,Long> {
    boolean existsByName(String name);

    List<CoreState> findByStatus(Status status);

    CoreState findByStateCode(String stateCode);

    List<CoreState> findAllByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}
