package com.jinadam.jupiter.biz.shared.user.impl;


import com.jinadam.jupiter.biz.shared.user.UsersManager;
import com.jinadam.jupiter.biz.shared.user.converter.UserBizConverter;
import com.jinadam.jupiter.common.facade.user.model.UsersDTO;
import com.jinadam.jupiter.core.model.user.UsersEntity;
import com.jinadam.jupiter.core.service.user.UsersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Adam
 * 2025-09-04 12:33
 */
@Service
public class UsersManagerImpl implements UsersManager {

    @Resource
    UsersService usersService;

    @Override
    public UsersDTO findById(Long id) {
        UsersEntity entity = usersService.findById(id);
        return UserBizConverter.INSTANCE.toS(entity);
    }
}
