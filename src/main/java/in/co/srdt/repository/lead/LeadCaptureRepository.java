package in.co.srdt.repository.lead;

import in.co.srdt.entity.lead.LeadCapture;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadCaptureRepository extends JpaRepository<LeadCapture,Long> {
    boolean existsByPhone(String phone);
    List<LeadCapture> findAll(Sort sort);

}
