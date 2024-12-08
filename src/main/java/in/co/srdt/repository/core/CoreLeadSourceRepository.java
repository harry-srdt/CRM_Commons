package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreLeadSource;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreLeadSourceRepository extends JpaRepository<CoreLeadSource, Long> {
    List<CoreLeadSource> findByStatus(Status status);

    boolean existsByName(String name);
}

