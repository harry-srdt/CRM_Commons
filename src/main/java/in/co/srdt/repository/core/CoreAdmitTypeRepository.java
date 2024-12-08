package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreAdmitType;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreAdmitTypeRepository extends JpaRepository<CoreAdmitType, Long> {
    List<CoreAdmitType> findByStatus(Status status);
}
