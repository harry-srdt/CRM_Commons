package in.co.srdt.repository.integration;

import in.co.srdt.entity.integration.IVR_OutboundCallbackDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboundCallbackDataRepository extends JpaRepository<IVR_OutboundCallbackDataEntity,Long> {

    IVR_OutboundCallbackDataEntity findByRefid(String trackId);

}
