package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreAcademicProgramYearlyFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoreAcademicProgramYearlyFeeRepository extends JpaRepository<CoreAcademicProgramYearlyFee, Long> {

    List<CoreAcademicProgramYearlyFee> findAllByCoreAcademicProgram_AcademicProgramId(Long academicProgramId);

    Optional<CoreAcademicProgramYearlyFee> findTopByCoreAcademicProgram_AcademicProgramIdOrderByEffectiveDateDesc(Long academicProgramId);
}
