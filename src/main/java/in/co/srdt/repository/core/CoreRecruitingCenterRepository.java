package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreRecruitingCenter;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoreRecruitingCenterRepository extends JpaRepository<CoreRecruitingCenter,Long> {
    boolean existsByName(String name);

    List<CoreRecruitingCenter> findByStatus(Status status);
}
