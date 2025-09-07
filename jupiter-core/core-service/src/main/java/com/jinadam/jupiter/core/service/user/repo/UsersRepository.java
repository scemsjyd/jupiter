package com.jinadam.jupiter.core.service.user.repo;


import com.jinadam.jupiter.core.model.user.UsersEntity;

/**
 * @author Adam
 * 2025-09-05 17:03
 */
public interface UsersRepository {
    UsersEntity findByUsername(String username);

    void updatePasswordById(String newPassMd5, Long id);

    UsersEntity findById(Long id);
}
