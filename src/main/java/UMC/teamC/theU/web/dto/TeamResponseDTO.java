package UMC.teamC.theU.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

public class TeamResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateResponse {
        private Long id;

        private Map<Long, String> infomationList;

        private String Url;

        private String enterCode;

        LocalDateTime createdAt;
    }
}
