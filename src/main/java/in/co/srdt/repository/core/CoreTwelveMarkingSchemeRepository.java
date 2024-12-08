package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreTwelveMarkingScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreTwelveMarkingSchemeRepository extends JpaRepository<CoreTwelveMarkingScheme,Long> {
}
