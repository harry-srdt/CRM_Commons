package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreActivityOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreActivityOutcomeRepository extends JpaRepository<CoreActivityOutcome,Long> {
}
