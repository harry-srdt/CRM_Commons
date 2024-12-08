package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.entity.lead.LeadScheduledTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeadScheduledTaskRepository extends JpaRepository<LeadScheduledTask,Long> {

    List<LeadScheduledTask> findByScheduledDate(LocalDate scheduledDate);

    List<LeadScheduledTask> findByScheduledDateAndLeadCapture(LocalDate scheduledDate,LeadCapture leadCapture);

    List<LeadScheduledTask> findByLeadCapture(LeadCapture leadCapture);


}
