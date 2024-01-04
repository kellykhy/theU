package UMC.teamC.theU.repository;

import UMC.teamC.theU.entity.Information;
import UMC.teamC.theU.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
