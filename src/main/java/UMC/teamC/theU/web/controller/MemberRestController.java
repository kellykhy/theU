package UMC.teamC.theU.web.controller;

import UMC.teamC.theU.apiPayload.ApiResponse;
import UMC.teamC.theU.converter.MemberConverter;
import UMC.teamC.theU.entity.Member;
import UMC.teamC.theU.service.MemberService;
import UMC.teamC.theU.web.dto.MemberRequestDTO;
import UMC.teamC.theU.web.dto.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberService memberCommandService;


    @Operation(
            summary = "가입(프로필 등록) API입니다.",
            description = "GetDto DTO 입니다. 값을 정확하게 입력해 주세요 Body입니다!"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @PostMapping("/join")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.joinResultDTO(member));
    }

    @Operation(
            summary = "조회 API입니다.",
            description = "GetDto DTO 입니다. 값을 정확하게 입력해 주세요 RequestParm입니다!"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @GetMapping
    public ApiResponse<MemberResponseDTO.GetResultDTO> join(@RequestParam(name = "teamId") Long teamId){
        MemberResponseDTO.GetResultDTO getResultDTO = memberCommandService.getMembers(teamId);

        return ApiResponse.onSuccess(getResultDTO);
    }

    @Operation(
            summary = "로그인 API입니다.",
            description = "LoginDto는 DTO 입니다. 값을 정확하게 입력해 주세요 Body입니다!"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "teamUrl", description = "teamUrl을 넣어주세요. RequestParm입니다.")
    })
    @PostMapping("/login/{teamUrl}")
    public ApiResponse<MemberResponseDTO.LoginDTO> join(@RequestBody @Valid MemberRequestDTO.LoginDto request,
                                                        @RequestParam(name="teamUrl") String teamUrl){
        Member member = memberCommandService.loginMember(request, teamUrl);

        return ApiResponse.onSuccess(MemberConverter.loginResultDTO(member));
    }
}
