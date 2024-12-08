package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreTaskType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoreTaskTypeRepository extends JpaRepository<CoreTaskType, Long> {
    List<CoreTaskType> findByCategory_CategoryId(Long categoryId);
}
