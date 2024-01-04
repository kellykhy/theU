package UMC.teamC.theU.web.controller;

import UMC.teamC.theU.apiPayload.ApiResponse;
import UMC.teamC.theU.entity.Question;
import UMC.teamC.theU.service.QuestionService;
import UMC.teamC.theU.web.dto.QuestionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService)
    {
        this.questionService = questionService;
    }

    @Operation(
            summary = "질문 추가 API입니다.",
            description = "질문 추가 API입니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "QuestionForm", description = "QuestionForm은 memberId와 content(질문)을 적어주시면 됩니다. Body로 넘겨주셔야 합니다.")
    })
    @PostMapping("/questions/new")
    public Long create(@RequestBody QuestionForm form){
        Question question = new Question();
        question.setContent(form.getContent());
        question.setMemberId(form.getMemberId());

        return questionService.join(question);
    }

    @Operation(
            summary = "질문 리스트를 가져오는 API입니다.",
            description = "질문 리스트를 가져오는 API입니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @GetMapping("/questions")
    public ApiResponse<List<QuestionResponseDTO.QuestionDTO>> getQuestionList(@RequestParam("teamId") Long teamId) {
        List<Question> questionList = questionService.findQuestions(teamId);

        List<QuestionResponseDTO.QuestionDTO> questionDTOList = new ArrayList<>();

        for(Question q : questionList) {
            QuestionResponseDTO.QuestionDTO dto = QuestionResponseDTO.QuestionDTO.builder()
                    .id(q.getId())
                    .mamberId(q.getMemberId())
                    .question(q.getContent())
                    .build();

            questionDTOList.add(dto);
        }

        return ApiResponse.onSuccess(questionDTOList);
    }
}
