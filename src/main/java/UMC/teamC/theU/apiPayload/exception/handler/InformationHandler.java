package UMC.teamC.theU.apiPayload.exception.handler;

import UMC.teamC.theU.apiPayload.code.BaseErrorCode;
import UMC.teamC.theU.apiPayload.exception.GeneralException;

public class InformationHandler extends GeneralException {
    public InformationHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
