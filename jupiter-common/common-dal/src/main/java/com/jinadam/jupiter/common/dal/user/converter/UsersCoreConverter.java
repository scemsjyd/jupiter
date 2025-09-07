package com.jinadam.jupiter.common.dal.user.converter;


import com.jinadam.jupiter.common.dal.user.model.UsersPO;
import com.jinadam.jupiter.common.util.converter.BaseConverter;
import com.jinadam.jupiter.core.model.user.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Adam
 * 2025-09-04 12:26
 */
@Mapper
public interface UsersCoreConverter extends BaseConverter<UsersEntity, UsersPO> {
    UsersCoreConverter INSTANCE = Mappers.getMapper(UsersCoreConverter.class);
}
