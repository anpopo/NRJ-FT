package anpopo.naranji.ft.naranjift.domains.btc.common;

import lombok.Getter;

@Getter
public enum NRJResponseStatus {

        SUCCESS_DEFAULT("S0000", "성공"),
        SUCCESS_CREATE("S0001", "생성 성공"),
        ERROR_DEFAULT("E0000", "에러"),
        ERROR_NOT_FOUND("E0004", "존재하지 않는 데이터"),
        ;

        private final String code;
        private final String message;

        NRJResponseStatus(String code, String message) {
            this.code = code;
            this.message = message;
        }
}
