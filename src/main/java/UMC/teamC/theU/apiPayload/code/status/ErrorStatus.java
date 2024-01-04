package UMC.teamC.theU.apiPayload.code.status;

import UMC.teamC.theU.apiPayload.code.BaseErrorCode;
import UMC.teamC.theU.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_500", "서버 에러, 관리자에게 문의 바랍니다."),

    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON_400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON_401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON_403", "금지된 요청입니다."),

    // Member 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER_400_1", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER_400_2", "닉네임은 필수 입니다."),

    // Information
    INFORMATION_NOT_FOUND(HttpStatus.NOT_FOUND, "INFORMATION_404_1", "프로필 항목이 존재하지 않습니다."),

    // Member
    INVALID_USER(HttpStatus.UNAUTHORIZED, "LOGIN_401", "로그인 실패"),

    TEAM_NOT_FOUND(HttpStatus.UNAUTHORIZED, "TEAM_NOT_FOUND_401", "팀을 찾을 수 없음"),

    BAD_ENTER_CODE(HttpStatus.UNAUTHORIZED, "ENTER_COED_401", "입장 코드 불일치"),
    ;


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .isSuccess(false)
                .message(message)
                .code(code)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .isSuccess(false)
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}
