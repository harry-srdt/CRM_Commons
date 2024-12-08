package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.entity.lead.LeadNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadNotesRepository extends JpaRepository<LeadNotes,Long> {

    List<LeadNotes> findAllByLeadCapture(LeadCapture leadCapture);
}
