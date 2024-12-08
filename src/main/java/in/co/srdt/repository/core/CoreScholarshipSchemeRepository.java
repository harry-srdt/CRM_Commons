package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreScholarshipCategory;
import in.co.srdt.entity.coresetup.CoreScholarshipScheme;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoreScholarshipSchemeRepository extends JpaRepository<CoreScholarshipScheme, Long> {
    boolean existsByNameAndScholarshipCategory(String name, CoreScholarshipCategory scholarshipCategory);

    List<CoreScholarshipScheme> findByStatus(Status status);

    List<CoreScholarshipScheme> findAllByScholarshipCategory_ScholarshipCategoryId(Long scholarshipCategoryId);
}
