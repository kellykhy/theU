package UMC.teamC.theU.service;

import UMC.teamC.theU.entity.Member;
import UMC.teamC.theU.web.dto.MemberRequestDTO;
import UMC.teamC.theU.web.dto.MemberResponseDTO;

import java.util.List;

public interface MemberService {
    public Member joinMember(MemberRequestDTO.JoinDto joinDto);
    public MemberResponseDTO.GetResultDTO getMembers(MemberRequestDTO.GetDto getDto);
    public Member loginMember(MemberRequestDTO.LoginDto loginDto);
}
