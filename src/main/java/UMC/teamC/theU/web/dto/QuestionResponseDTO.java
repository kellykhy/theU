package UMC.teamC.theU.web.dto;

import UMC.teamC.theU.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

public class QuestionResponseDTO {

        @Builder
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
    public static class QuestionDTO {
        private Long id;
        private Long mamberId;
        private String question;
    }

    public static class QuestionList {
        List<QuestionDTO> QuestionDTOList;
    }
}
