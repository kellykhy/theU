package UMC.teamC.theU.repository;

import UMC.teamC.theU.entity.Question;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaQuestionRepository implements QuestionRepository {
    private final EntityManager em;

    public JpaQuestionRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Long save(Question question){
        em.merge(question);
        return 0L;
    }

    @Override
    public List<Question> findAll(Long teamId){
        return em.createQuery("select m from Question m where m.team.id = :teamId", Question.class)
                .getResultList();
    }

}
