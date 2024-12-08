package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreSalesRepDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreSalesRepDetailsRepository extends JpaRepository<CoreSalesRepDetails ,Long> {
}
