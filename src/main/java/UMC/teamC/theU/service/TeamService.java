package UMC.teamC.theU.service;

import UMC.teamC.theU.web.dto.MemberRequestDTO;
import UMC.teamC.theU.web.dto.TeamRequestDTO;
import UMC.teamC.theU.web.dto.TeamResponseDTO;

public interface TeamService {
    public TeamResponseDTO.CreateResponse createTeam(TeamRequestDTO.CreateDTO createDTO);

}
