package UMC.teamC.theU.web.controller;

import UMC.teamC.theU.apiPayload.ApiResponse;
import UMC.teamC.theU.converter.TeamConverter;
import UMC.teamC.theU.service.TeamService;
import UMC.teamC.theU.web.dto.MemberRequestDTO;
import UMC.teamC.theU.web.dto.TeamRequestDTO;
import UMC.teamC.theU.web.dto.TeamResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @Operation(
            summary = "팀을 생성하는 API입니다.",
            description = "팀을 생성하는 API. 추가설명"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "createDTO", description = "팀(방)에 대해 필요한 정보입니다. RequestBody로 넘겨주세요, informationList는 상세 정보의 String List 입니다.")
    })
    @PostMapping("team")
    public ApiResponse<TeamResponseDTO.CreateResponse> createTeam(@RequestBody TeamRequestDTO.CreateDTO createDTO) {
        return ApiResponse.onSuccess(teamService.createTeam(createDTO));
    }

//    @GetMapping("/{teamId}")
//    public ApiResponse<> getTeamPage() {
//        return ApiResponse.onSuccess(teamService.createTeam(createDTO));
//    }
}
