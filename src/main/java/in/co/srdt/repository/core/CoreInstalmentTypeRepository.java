package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreInstalmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreInstalmentTypeRepository extends JpaRepository<CoreInstalmentType,Long> {
    boolean existsByName(String name);
}
