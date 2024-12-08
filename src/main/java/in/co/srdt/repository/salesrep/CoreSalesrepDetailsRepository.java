package in.co.srdt.repository.salesrep;

import in.co.srdt.entity.salesrep.CoreSalesrepDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreSalesrepDetailsRepository extends JpaRepository<CoreSalesrepDetails,Long> {

    CoreSalesrepDetails findByUsername(String username);

}
