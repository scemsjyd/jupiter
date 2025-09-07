package com.jinadam.jupiter.common.util.exception;


/**
 * @author Adam
 * 2025-09-04 19:42
 */
public class BizException extends RuntimeException{
    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
