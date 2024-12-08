package in.co.srdt.repository.integration;

import in.co.srdt.entity.integration.IVR_OutboundPlaceCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVR_OutboundPlaceCallRepository extends JpaRepository<IVR_OutboundPlaceCall,Long> {
}
