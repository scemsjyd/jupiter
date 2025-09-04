package com.jinadam.jupiter.common.util.converter;


import java.util.List;

/**
 * @author Adam
 * 2025-09-04 12:26
 */
public interface BaseConverter<S, T> {
    T toT(S s);

    List<T> toT(List<S> sList);

    S toS(T t);

    List<S> toS(List<T> tList);
}
