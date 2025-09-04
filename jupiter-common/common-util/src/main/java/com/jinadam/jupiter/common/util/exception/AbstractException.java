package com.jinadam.jupiter.common.util.exception;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Adam
 * 2025-09-04 19:46
 */
public abstract class AbstractException extends RuntimeException {
    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String message;

    public AbstractException(Integer code) {
    }

    public AbstractException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public AbstractException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractException(Throwable cause) {
        super(cause);
    }

    protected AbstractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
