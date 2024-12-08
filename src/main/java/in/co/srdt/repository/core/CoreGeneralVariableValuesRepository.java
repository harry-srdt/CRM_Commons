package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreGeneralVariableValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreGeneralVariableValuesRepository extends JpaRepository<CoreGeneralVariableValues,Long> {
}
