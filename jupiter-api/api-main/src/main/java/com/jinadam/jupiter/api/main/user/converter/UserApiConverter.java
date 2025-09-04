package com.jinadam.jupiter.api.main.user.converter;


import com.jinadam.jupiter.api.main.user.resp.UsersResp;
import com.jinadam.jupiter.common.facade.user.model.UsersDTO;
import com.jinadam.jupiter.common.util.converter.BaseConverter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Adam
 * 2025-09-04 12:49
 */
@Mapper
public interface UserApiConverter extends BaseConverter<UsersResp, UsersDTO> {
    UserApiConverter INSTANCE = Mappers.getMapper(UserApiConverter.class);
}
