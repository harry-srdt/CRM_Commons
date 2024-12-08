package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreScholarshipScheme;
import in.co.srdt.entity.coresetup.CoreScholarshipSlab;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoreScholarshipSlabRepository extends JpaRepository<CoreScholarshipSlab, Long> {
    boolean existsByNameAndScholarshipScheme(String name, CoreScholarshipScheme scheme);

    List<CoreScholarshipSlab> findByStatus(Status status);

    List<CoreScholarshipSlab> findAllByScholarshipScheme_ScholarshipSchemeId(Long schemeId);
}
