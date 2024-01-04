package UMC.teamC.theU.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;


public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        String name;
        String passwd;
        String introduce;
        Long teamId;
        Map<Long, String> answer;
    }
    @Getter
    public static class GetDto{
        Long team_id;
    }
    @Getter
    public static class LoginDto{
        Long teamId;
        String name;
        String passwd;
    }
}
