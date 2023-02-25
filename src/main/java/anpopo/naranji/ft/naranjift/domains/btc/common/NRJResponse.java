package anpopo.naranji.ft.naranjift.domains.btc.common;

import java.util.Objects;
import lombok.Getter;

@Getter
public class NRJResponse <T>{
    private final T data;
    private final String message;
    private final String code;

    private NRJResponse (NRJResponseStatus status, String message) {
        this.data = null;
        this.message = Objects.requireNonNullElseGet(message, status::getMessage);
        this.code = status.getCode();
    }

    private NRJResponse(T data, NRJResponseStatus status) {
        this.data = data;
        this.message = status.getMessage();
        this.code = status.getCode();
    }


    public static <T> NRJResponse<T> ok(T data) {
        return new NRJResponse<>(data, NRJResponseStatus.SUCCESS_DEFAULT);
    }

    public static <T> NRJResponse<T> ok(T data, NRJResponseStatus status) {
        return new NRJResponse<>(data, status);
    }

    public static<T> NRJResponse<T> fail(NRJResponseStatus status, String message) {
        return new NRJResponse<>(status, message);
    }
}
