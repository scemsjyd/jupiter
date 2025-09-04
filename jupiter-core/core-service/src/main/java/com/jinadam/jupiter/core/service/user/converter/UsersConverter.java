package com.jinadam.jupiter.core.service.user.converter;


import com.jinadam.jupiter.common.dal.model.UsersPO;
import com.jinadam.jupiter.common.util.converter.BaseConverter;
import com.jinadam.jupiter.core.model.user.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Adam
 * 2025-09-04 12:26
 */
@Mapper
public interface UsersConverter extends BaseConverter<UsersEntity, UsersPO> {
    UsersConverter INSTANCE = Mappers.getMapper(UsersConverter.class);
}
