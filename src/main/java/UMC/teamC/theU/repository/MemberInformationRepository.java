package UMC.teamC.theU.repository;

import UMC.teamC.theU.entity.MemberInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInformationRepository extends JpaRepository<MemberInformation, Long> {
}
