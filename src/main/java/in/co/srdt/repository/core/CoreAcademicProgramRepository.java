package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreAcademicCareer;
import in.co.srdt.entity.coresetup.CoreAcademicProgram;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreAcademicProgramRepository extends JpaRepository<CoreAcademicProgram, Long> {

       /* @Query("SELECT cap FROM CoreAcademicProgram cap WHERE cap.coreAcademicCareer.academicCareerId = :academicCareerId AND cap.status = :status")
    List<CoreAcademicProgram> findAllByAcademicCareerIdAndStatus(@Param("academicCareerId") Long academicCareerId, @Param("status") Status status);

    @Query("SELECT cap FROM CoreAcademicProgram cap WHERE cap.coreAcademicCareer.academicCareerId = :academicCareerId ")
    List<CoreAcademicProgram> findAllByAcademicCareerId(@Param("academicCareerId") Long academicCareerId);
*/


    List<CoreAcademicProgram> findAllByCoreAcademicCareerAcademicCareerIdAndStatus(Long academicCareerId, Status status);

    List<CoreAcademicProgram> findAllByCoreAcademicCareerAcademicCareerId(Long academicCareerId);

    boolean existsByName(String name);

    boolean existsByNameAndCoreAcademicCareer(String name, CoreAcademicCareer coreAcademicCareer);
}
