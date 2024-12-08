package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreWhatsappMediaAttachment;
import in.co.srdt.entity.coresetup.CoreWhatsappTemplates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreWhatsappMediaAttachmentRepository extends JpaRepository<CoreWhatsappMediaAttachment,Long> {

    CoreWhatsappMediaAttachment findByWhatsappTemplates(CoreWhatsappTemplates coreWhatsappTemplates);

}
