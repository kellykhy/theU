package UMC.teamC.theU.converter;

import UMC.teamC.theU.entity.Member;
import UMC.teamC.theU.entity.Team;
import UMC.teamC.theU.web.dto.MemberRequestDTO;
import UMC.teamC.theU.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO joinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDto joinDto, Team team){
        return Member.builder()
                .name(joinDto.getName())
                .team(team)
                .passwd(joinDto.getPasswd())
                .introduction(joinDto.getIntroduce())
                .build();
    }
}
