package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreCampus;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreCampusRepository extends JpaRepository<CoreCampus, Long> {
    List<CoreCampus> findByStatus(Status status);

    boolean existsByName(String name);
}
