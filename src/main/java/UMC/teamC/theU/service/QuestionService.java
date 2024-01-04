package UMC.teamC.theU.service;

import UMC.teamC.theU.apiPayload.code.status.ErrorStatus;
import UMC.teamC.theU.apiPayload.exception.GeneralException;
import UMC.teamC.theU.entity.Question;
import UMC.teamC.theU.entity.Team;
import UMC.teamC.theU.repository.QuestionRepository;
import UMC.teamC.theU.repository.TeamRepository;
import UMC.teamC.theU.web.controller.QuestionForm;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TeamRepository teamRepository;

    public Long join(QuestionForm form, Long teamId){
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new GeneralException(ErrorStatus.TEAM_NOT_FOUND));

        Question question = Question.builder()
                .content(form.getContent())
                .memberId(form.getMemberId())
                .team(team)
                .build();

        questionRepository.save(question);

        return question.getId();
    }

    public List<Question> findQuestions(Long teamId)
    {
        return questionRepository.findAll(teamId);
    }
}
