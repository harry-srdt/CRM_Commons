package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreAdmissionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreAdmissionProcessRepository extends JpaRepository<CoreAdmissionProcess,Long> {
}
