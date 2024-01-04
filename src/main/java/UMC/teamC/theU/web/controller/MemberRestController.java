package UMC.teamC.theU.web.controller;

import UMC.teamC.theU.apiPayload.ApiResponse;
import UMC.teamC.theU.converter.MemberConverter;
import UMC.teamC.theU.entity.Member;
import UMC.teamC.theU.service.MemberService;
import UMC.teamC.theU.web.dto.MemberRequestDTO;
import UMC.teamC.theU.web.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberService memberCommandService;
    @PostMapping("/join")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.joinResultDTO(member));
    }
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.GetResultDTO> join(@RequestBody @Valid MemberRequestDTO.GetDto request){
        MemberResponseDTO.GetResultDTO getResultDTO = memberCommandService.getMembers(request);

        return ApiResponse.onSuccess(getResultDTO);
    }
    @PostMapping("/login")
    public ApiResponse<MemberResponseDTO.LoginDTO> join(@RequestBody @Valid MemberRequestDTO.LoginDto request){
        Member member = memberCommandService.loginMember(request);

        return ApiResponse.onSuccess(MemberConverter.loginResultDTO(member));
    }
}
