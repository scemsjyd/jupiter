package com.jinadam.jupiter.common.util.core;


import com.jinadam.jupiter.common.util.constants.ErrorCode;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Adam
 * 2025-09-04 19:40
 */
@Data
@Accessors(chain = true)
public class ApiResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * response result status code
     */
    private Integer code;

    /**
     * response error msg
     */
    private String msg;

    /**
     * response biz data
     */
    private T data;

    public ApiResult(Integer code) {
        this.code = code;
    }

    public ApiResult(T data) {
        this.code = 200;
        this.data = data;
    }

    public ApiResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ApiResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(ErrorCode.COMMON.SUCCESS, data);
    }

    public static <T> ApiResult<T> fail(Integer code, String msg) {
        return new ApiResult<>(code, msg, null);
    }
}
