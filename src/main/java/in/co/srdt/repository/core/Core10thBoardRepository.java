package in.co.srdt.repository.core;


import in.co.srdt.entity.coresetup.Core10thBoard;
import in.co.srdt.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Core10thBoardRepository extends JpaRepository<Core10thBoard,Long> {
    List<Core10thBoard> findByStatus(Status status);

    boolean existsByName(String name);
}
