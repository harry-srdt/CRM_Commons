package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreCategoryRepository extends JpaRepository<CoreCategory,Long> {
    boolean existsByName(String name);
}
