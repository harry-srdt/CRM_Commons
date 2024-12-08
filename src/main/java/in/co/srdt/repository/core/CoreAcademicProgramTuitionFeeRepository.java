package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreAcademicProgramTutionFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoreAcademicProgramTuitionFeeRepository extends JpaRepository<CoreAcademicProgramTutionFee, Long> {

    List<CoreAcademicProgramTutionFee> findByCoreAcademicProgram_AcademicProgramId(Long academicProgramId);

    Optional<CoreAcademicProgramTutionFee> findTopByCoreAcademicProgram_AcademicProgramIdOrderByEffectiveDateDesc(Long academicProgramId);
}
