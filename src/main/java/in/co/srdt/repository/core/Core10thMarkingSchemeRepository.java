package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.Core10thMarkingScheme;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Core10thMarkingSchemeRepository extends JpaRepository<Core10thMarkingScheme,Long> {
    List<Core10thMarkingScheme> findByStatus(Status status);
}
