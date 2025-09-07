package com.jinadam.jupiter.core.service.user.impl;

import com.jinadam.jupiter.core.model.user.UsersEntity;
import com.jinadam.jupiter.core.service.user.UsersService;
import com.jinadam.jupiter.core.service.user.repo.UsersRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Adam
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    UsersRepository usersRepository;


    @Override
    public UsersEntity findById(Long id) {
        return usersRepository.findById(id);
    }
}
