package UMC.teamC.theU.service;

import UMC.teamC.theU.converter.TeamConverter;
import UMC.teamC.theU.entity.Information;
import UMC.teamC.theU.entity.Team;
import UMC.teamC.theU.repository.InformationRepository;
import UMC.teamC.theU.repository.TeamRepository;
import UMC.teamC.theU.web.dto.TeamRequestDTO;
import UMC.teamC.theU.web.dto.TeamResponseDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamServicelmpl implements TeamService {
    private TeamRepository teamRepository;
    private InformationRepository informationRepository;

    @Override
    @Transactional
    public TeamResponseDTO.CreateResponse createTeam(TeamRequestDTO.CreateDTO createDTO) {
        Team team = teamRepository.save(TeamConverter.toTeam(createDTO));

        // 연관관계 편의 메서드 안함
        List<Information> informationList = createDTO.getInformationList().stream()
                .map(info -> Information.builder()
                                .team(team)
                                .question(info)
                                .build())
                .collect(Collectors.toList());

        informationRepository.saveAll(informationList);

        Double rand = Math.floor(Math.random() * 1000000);
        team.setEnterCode(rand.toString().substring(0, 6));     // ㅜㅜ 나중에 고치기
        teamRepository.save(team);

        // 컨터너 ㄴ
        return TeamResponseDTO.CreateResponse.builder()
                .id(team.getId())
                .infomationList(informationList.stream()
                        .collect(Collectors.toMap(Information::getId, Information::getQuestion)))
                .createdAt(LocalDateTime.now())
                .Url("team/" + team.getId())    // 하드코딩
                .enterCode(team.getEnterCode())
                .build();
    }

    private Team valiedTeam(TeamRequestDTO.CreateDTO createDTO) {
        return null;
    }
}
