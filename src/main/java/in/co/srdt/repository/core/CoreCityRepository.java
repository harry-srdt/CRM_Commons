package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreCity;
import in.co.srdt.entity.coresetup.CoreState;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoreCityRepository extends JpaRepository<CoreCity,Long> {
    List<CoreCity> findByStatus(Status status);

    List<CoreCity> findAllByCoreState_coreStateId(Long coreStateId);

    boolean existsByNameAndCoreState(String cityName, CoreState state);
}
