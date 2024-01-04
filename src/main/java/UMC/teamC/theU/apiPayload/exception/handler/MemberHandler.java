package UMC.teamC.theU.apiPayload.exception.handler;

import UMC.teamC.theU.apiPayload.code.BaseErrorCode;
import UMC.teamC.theU.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
            super(errorCode);
        }

}
