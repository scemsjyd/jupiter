package com.jinadam.jupiter.biz.shared.user.converter;


import com.jinadam.jupiter.common.facade.user.model.UsersDTO;
import com.jinadam.jupiter.common.util.converter.BaseConverter;
import com.jinadam.jupiter.core.model.user.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Adam
 * 2025-09-04 12:41
 */
@Mapper
public interface UserBizConverter extends BaseConverter<UsersDTO, UsersEntity> {
    UserBizConverter INSTANCE = Mappers.getMapper(UserBizConverter.class);
}
