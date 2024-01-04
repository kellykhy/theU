package UMC.teamC.theU.apiPayload.exception.handler;

import UMC.teamC.theU.apiPayload.code.BaseErrorCode;
import UMC.teamC.theU.apiPayload.exception.GeneralException;

public class TeamHandler extends GeneralException {

    public TeamHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
