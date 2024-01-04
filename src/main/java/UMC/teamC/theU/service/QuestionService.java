package UMC.teamC.theU.service;

import UMC.teamC.theU.entity.Question;
import UMC.teamC.theU.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Long join(Question question){
        questionRepository.save(question);
        return question.getId();
    }

    public List<Question> findQuestions(Long teamId)
    {
        return questionRepository.findAll(teamId);
    }
}
