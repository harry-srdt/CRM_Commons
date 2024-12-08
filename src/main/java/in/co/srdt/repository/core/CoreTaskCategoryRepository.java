package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreTaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreTaskCategoryRepository extends JpaRepository<CoreTaskCategory,Long> {

}
