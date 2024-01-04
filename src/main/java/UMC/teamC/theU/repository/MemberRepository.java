package UMC.teamC.theU.repository;

import UMC.teamC.theU.entity.Member;
import UMC.teamC.theU.web.dto.MemberRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}