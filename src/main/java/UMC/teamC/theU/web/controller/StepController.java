package UMC.teamC.theU.web.controller;

import UMC.teamC.theU.apiPayload.ApiResponse;
import UMC.teamC.theU.service.StepService;
import UMC.teamC.theU.web.dto.StepResponsDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StepController {
    private final StepService stepService;

    @GetMapping("/{teamUrl}/stepOne")
    public ApiResponse<StepResponsDTO.StepOneRes> stepOne(@RequestParam(name = "roomId") Long roomId,
                                                          @RequestParam(name = "teamUrl") Long teamUrl) {
        return null;
    }
}
