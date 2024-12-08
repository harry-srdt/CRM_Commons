package in.co.srdt.repository.core;


import in.co.srdt.entity.coresetup.CoreAcademicCareer;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreAcademicCareerRepository extends JpaRepository<CoreAcademicCareer, Long> {
    List<CoreAcademicCareer> findByStatus(Status status);

    boolean existsByName(String name);
}