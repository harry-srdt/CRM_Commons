package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreSession;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoreSessionRepository extends JpaRepository<CoreSession,Long> {
    boolean existsByName(String name);

    List<CoreSession> findByStatus(Status status);
}
