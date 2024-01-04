package UMC.teamC.theU.service;

import UMC.teamC.theU.apiPayload.code.status.ErrorStatus;
import UMC.teamC.theU.apiPayload.exception.handler.InformationHandler;
import UMC.teamC.theU.apiPayload.exception.handler.TeamHandler;
import UMC.teamC.theU.converter.MemberConverter;
import UMC.teamC.theU.entity.*;
import UMC.teamC.theU.repository.InformationRepository;
import UMC.teamC.theU.repository.MemberInformationRepository;
import UMC.teamC.theU.repository.MemberRepository;
import UMC.teamC.theU.repository.TeamRepository;
import UMC.teamC.theU.web.dto.MemberRequestDTO;
import UMC.teamC.theU.web.dto.MemberResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final MemberInformationRepository memberInformationRepository;
    private final InformationRepository informationRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto joinDto) {
        Team nowTeam = teamRepository.findById(joinDto.getTeamId()).orElseThrow(() -> new TeamHandler(ErrorStatus.TEAM_NOT_FOUND));
        Member newMember = MemberConverter.toMember(joinDto, nowTeam);
        memberRepository.save(newMember);
        List<MemberInformation> memberInformationList = new ArrayList<>();
        if (joinDto.getAnswer()!=null){
            for (Long key : joinDto.getAnswer().keySet()) {
                Information information = informationRepository.findById(key).orElseThrow(() -> new InformationHandler(ErrorStatus.INFORMATION_NOT_FOUND));
                memberInformationList.add(MemberInformation.builder()
                        .member(newMember)
                        .information(information)
                        .answer(joinDto.getAnswer().get(key))
                        .build());
            }
            memberInformationRepository.saveAll(memberInformationList);
        }
        return newMember;
    }

    @Override
    @Transactional
    public MemberResponseDTO.GetResultDTO getMembers(MemberRequestDTO.GetDto getDto) {
        Team team = teamRepository.findById(getDto.getTeam_id()).orElseThrow(() -> new TeamHandler(ErrorStatus.TEAM_NOT_FOUND));
        HashMap<Long,String> informationMap = new HashMap<>();
        for (Information information:team.getInformationList()){
            informationMap.put(information.getId(), information.getQuestion());
        }
        List<Member> memberList = team.getMemberList();
        List<MemberResponseDTO.PersonDTO> personDTOList = new ArrayList<>();
        for (Member nowMember:memberList){
            List<MemberInformation> memberInformationList = nowMember.getMemberInformationList();
            List<MemberResponseDTO.AnswerDTO> answerDTOList = new ArrayList<>();
            for (MemberInformation memberInformation: memberInformationList){
                answerDTOList.add(MemberResponseDTO.AnswerDTO.builder()
                        .question(informationMap.get(memberInformation.getInformation().getId()))
                        .answer(memberInformation.getAnswer())
                        .build());
            }
            personDTOList.add(MemberResponseDTO.PersonDTO.builder()
                    .name(nowMember.getName())
                    .introduce(nowMember.getIntroduction())
                    .answerDTOList(answerDTOList)
                    .build());
        }

        return MemberResponseDTO.GetResultDTO.builder()
                .personDTOList(personDTOList)
                .build();
    }
}
