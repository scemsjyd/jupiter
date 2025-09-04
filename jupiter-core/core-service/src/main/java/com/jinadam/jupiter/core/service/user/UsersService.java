package com.jinadam.jupiter.core.service.user;

import com.jinadam.jupiter.core.model.user.UsersEntity;

/**
 * @author Adam
 */
public interface UsersService {
    UsersEntity findById(Long id);
}
