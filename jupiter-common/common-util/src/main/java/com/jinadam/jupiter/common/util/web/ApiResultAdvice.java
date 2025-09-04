package com.jinadam.jupiter.common.util.web;


import cn.dev33.satoken.exception.SaTokenException;
import com.jinadam.jupiter.common.util.JSONUtil;
import com.jinadam.jupiter.common.util.core.ApiResult;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Adam
 * 2025-09-04 20:47
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.jinadam.jupiter")
public class ApiResultAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果返回类型已经是 Result，则不需要再次封装
        if (returnType.getParameterType().isAssignableFrom(ApiResult.class)) {
            return false;
        }

        // 这里可以根据实际情况添加其他需要排除的条件
        // 例如：returnType.hasMethodAnnotation(NotWrapper.class)
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果响应体是 String 类型，需要特殊处理，因为 Spring 默认的 StringConverter 会直接返回，导致类型转换异常
        if (body instanceof String) {
            return JSONUtil.toJSONString(ApiResult.success(body));
        }

        // 如果响应体是统一封装的 Result 类型，直接返回
        if (body instanceof ApiResult<?>) {
            return body;
        }

        // 否则，将响应体封装到统一的 Result 结构中
        return ApiResult.success(body);
    }

    @ExceptionHandler(value = Exception.class)
    public ApiResult<?> defaultExceptionHandler(Exception ex, HttpServletResponse response) {
        log.error("unknown exception", ex);
        return ApiResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
    }

    @ExceptionHandler(value = SaTokenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ApiResult<?> saExceptionHandler(SaTokenException ex, HttpServletResponse response) {
        log.error("sa exception", ex);
        return ApiResult.fail(HttpStatus.FORBIDDEN.value(), ex.getMessage());
    }
}
