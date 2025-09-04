package com.jinadam.jupiter.common.util.exception;


/**
 * @author Adam
 * 2025-09-04 19:42
 */
public class BizException extends AbstractException{

    public BizException(Integer code) {
        super(code);
    }

    public BizException(Integer code, String message) {
        super(code, message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Integer code, Throwable cause) {
        super(null, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    protected BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
