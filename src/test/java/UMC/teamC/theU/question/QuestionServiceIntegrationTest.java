package UMC.teamC.theU.question;

import UMC.teamC.theU.entity.Question;
import UMC.teamC.theU.repository.QuestionRepository;
import UMC.teamC.theU.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
public class QuestionServiceIntegrationTest {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionRepository questionRepository;
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

        //when
        Long saveId = questionService.join(question);
        List<Question> questions = questionService.findQuestions();
        for (Question q : questions) {
            System.out.println("question = " + q);
        }
    }
}
