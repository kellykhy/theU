package UMC.teamC.theU.converter;

import UMC.teamC.theU.entity.Team;
import UMC.teamC.theU.web.dto.TeamRequestDTO;

public class TeamConverter {

    public static Team toTeam(TeamRequestDTO.CreateDTO createDTO) {
        return Team.builder()
                .title(createDTO.getTitle())
                .subtitle(createDTO.getSubtitle())
                .date(createDTO.getDate())
                .introduction(createDTO.getIntroduction())
                .build();
    }
}
