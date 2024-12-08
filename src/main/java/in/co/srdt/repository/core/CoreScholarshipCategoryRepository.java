package in.co.srdt.repository.core;


import in.co.srdt.entity.coresetup.CoreScholarshipCategory;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreScholarshipCategoryRepository extends JpaRepository<CoreScholarshipCategory, Long> {
    List<CoreScholarshipCategory> findByStatus(Status active);

    boolean existsByName(String name);
}
