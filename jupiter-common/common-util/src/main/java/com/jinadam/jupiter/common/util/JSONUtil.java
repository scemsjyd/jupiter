package com.jinadam.jupiter.common.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinadam.jupiter.common.util.constants.ErrorCode;
import com.jinadam.jupiter.common.util.exception.BizException;

/**
 * @author Adam
 * 2025-09-04 20:54
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class JSONUtil {

    public static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JSONUtil() {
    }

    public static String toJSONString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new BizException(ErrorCode.COMMON.ERROR, e);
        }
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new BizException(ErrorCode.COMMON.ERROR, e);
        }
    }

    public static <T> T parseObject(String json, JavaType javaType) {
        try {
            return objectMapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            throw new BizException(ErrorCode.COMMON.ERROR, e);
        }
    }
}
