package anpopo.naranji.ft.naranjift.domains.btc.common;

import anpopo.naranji.ft.naranjift.domains.btc.exception.NRJCommonException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NRJExceptionHandler {

    @ExceptionHandler(NRJCommonException.class)
    public NRJResponse<Object> handleNRJCommonException(NRJCommonException e) {
        return NRJResponse.fail(e.getNrjStatus(), e.getMessage());
    }
}
