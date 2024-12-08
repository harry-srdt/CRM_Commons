package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.Core12thBoard;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Core12thBoardRepository extends JpaRepository<Core12thBoard,Long> {
    List<Core12thBoard> findByStatus(Status status);

    boolean existsByName(String name);
}
