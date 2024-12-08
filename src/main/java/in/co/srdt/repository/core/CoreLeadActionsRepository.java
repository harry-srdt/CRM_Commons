package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreLeadActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoreLeadActionsRepository extends JpaRepository<CoreLeadActions,Long> {

     Optional<CoreLeadActions> findByName(String name);

}
