package UMC.teamC.theU.question;

import UMC.teamC.theU.entity.Question;
import UMC.teamC.theU.entity.Team;
import UMC.teamC.theU.repository.QuestionRepository;
import UMC.teamC.theU.service.QuestionService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
public class QuestionServiceIntegrationTest {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    EntityManager em;

    @Test
    void joinTest() {
        //given
        Question question = new Question();
        question.setId(1L);
        question.setMemberId(1L);
        question.setContent("test question");

        //when
        Long saveId = questionService.join(question);

        //then
        assertThat(saveId).isEqualTo(6L);
    }


    @Test
    void findAllTest() {
        Question question = new Question();
        question.setId(1L);
        question.setMemberId(1L);
        question.setContent("test question");
        Team t = Team.builder()
                .id(1L)
                .title("test title")
                .subtitle("test subtitle")
                .build();
        em.persist(t);
        question.setTeam(t);

        //when
        Long saveId = questionService.join(question);
        List<Question> questions = questionService.findQuestions(1L);
        for (Question q : questions) {
            System.out.println("question = " + q);
        }
    }
}
