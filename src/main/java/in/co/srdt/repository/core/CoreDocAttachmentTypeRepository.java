package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreDocAttachmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreDocAttachmentTypeRepository extends JpaRepository<CoreDocAttachmentType,Long> {
}
