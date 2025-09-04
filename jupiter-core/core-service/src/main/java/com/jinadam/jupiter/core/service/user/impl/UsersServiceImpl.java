package com.jinadam.jupiter.core.service.user.impl;

import com.jinadam.jupiter.common.dal.mapper.UsersMapper;
import com.jinadam.jupiter.common.dal.model.UsersPO;
import com.jinadam.jupiter.core.model.user.UsersEntity;
import com.jinadam.jupiter.core.service.user.UsersService;
import com.jinadam.jupiter.core.service.user.converter.UsersConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Adam
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UsersEntity findById(Long id) {
        UsersPO po = usersMapper.selectById(id);
        return UsersConverter.INSTANCE.toS(po);
    }
}
