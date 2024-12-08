package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadDocAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadDocAttachmentRepository extends JpaRepository<LeadDocAttachment,Long> {
}
