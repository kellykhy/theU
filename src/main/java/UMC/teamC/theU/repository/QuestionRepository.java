package UMC.teamC.theU.repository;

import UMC.teamC.theU.entity.Question;

import java.util.List;

public interface QuestionRepository {
    Long save(Question question);

    List<Question> findAll();

}
