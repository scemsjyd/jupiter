package com.jinadam.jupiter.biz.shared.user;


import com.jinadam.jupiter.common.facade.user.model.UsersDTO;

/**
 * @author Adam
 * 2025-09-04 12:32
 */
public interface UsersManager {
    UsersDTO findById(Long id);
}
