package UMC.teamC.theU.service;

import UMC.teamC.theU.apiPayload.code.status.ErrorStatus;
import UMC.teamC.theU.apiPayload.exception.handler.InformationHandler;
import UMC.teamC.theU.apiPayload.exception.handler.TeamHandler;
import UMC.teamC.theU.converter.MemberConverter;
import UMC.teamC.theU.converter.TeamConverter;
import UMC.teamC.theU.entity.Information;
import UMC.teamC.theU.entity.Member;
import UMC.teamC.theU.entity.MemberInformation;
import UMC.teamC.theU.entity.Team;
import UMC.teamC.theU.repository.InformationRepository;
import UMC.teamC.theU.repository.MemberInformationRepository;
import UMC.teamC.theU.repository.MemberRepository;
import UMC.teamC.theU.repository.TeamRepository;
import UMC.teamC.theU.web.dto.MemberRequestDTO;
import UMC.teamC.theU.web.dto.TeamRequestDTO;
import UMC.teamC.theU.web.dto.TeamResponseDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamServicelmpl implements TeamService {
    private TeamRepository teamRepository;
    private InformationRepository informationRepository;
    private final MemberRepository memberRepository;
    private final MemberInformationRepository memberInformationRepository;

    @Override
    @Transactional
    public TeamResponseDTO.CreateResponse createTeam(TeamRequestDTO.CreateDTO createDTO) {
        Team team = teamRepository.save(TeamConverter.toTeam(createDTO));

        Member member = Member.builder()
                .name(createDTO.getName())
                .team(team)
                .passwd(createDTO.getPasswd())
                .introduction(createDTO.getIntroduce())
                .build();

        memberRepository.save(member);

        List<Information> informationList = createDTO.getInformationList().stream()
                .map(info -> Information.builder()
                        .team(team)
                        .question(info)
                        .build())
                .collect(Collectors.toList());

        informationRepository.saveAll(informationList);

        for (int i = 0; i < informationList.size(); i++) {
            MemberInformation mi = MemberInformation.builder()
                    .information(informationList.get(i))
                    .member(member)
                    .answer(createDTO.getAnswer().get(i))
                    .build();

            memberInformationRepository.save(mi);
        }

        // 연관관계 편의 메서드 안함
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
