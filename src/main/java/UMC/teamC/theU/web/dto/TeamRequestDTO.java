package UMC.teamC.theU.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class TeamRequestDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateDTO {
        private String title;

        private String subtitle;

        private String introduction;

        private LocalDate date;

        private List<String> informationList;
    }
}
