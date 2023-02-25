package anpopo.naranji.ft.naranjift.domains.btc.exception;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import lombok.Getter;

@Getter
public class NRJCommonException extends RuntimeException {
    private final NRJResponseStatus nrjStatus;

    public NRJCommonException() {
        super(NRJResponseStatus.ERROR_DEFAULT.getMessage());
        this.nrjStatus = NRJResponseStatus.ERROR_DEFAULT;
    }

    public NRJCommonException(NRJResponseStatus status) {
        super(status.getMessage());
        this.nrjStatus = status;
    }

    public NRJCommonException(NRJResponseStatus status, Throwable cause) {
        super(status.getMessage(), cause);
        this.nrjStatus = status;
    }

    public NRJCommonException(NRJResponseStatus status, String message) {
        super(message);
        this.nrjStatus = status;
    }

    public NRJCommonException(NRJResponseStatus status, Throwable cause, String message) {
        super(message, cause);
        this.nrjStatus = status;
    }
}
