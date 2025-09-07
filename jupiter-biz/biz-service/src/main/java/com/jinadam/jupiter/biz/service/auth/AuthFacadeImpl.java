package com.jinadam.jupiter.biz.service.auth;


import com.jinadam.jupiter.biz.shared.auth.AuthManager;
import com.jinadam.jupiter.common.facade.auth.AuthFacade;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Adam
 * 2025-09-05 16:36
 */
@Service
public class AuthFacadeImpl implements AuthFacade {

    @Resource
    AuthManager authManager;

    @Override
    public boolean validate(String username, String password) {
        return authManager.validate(username, password);
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return authManager.changePassword(username, oldPassword, newPassword);
    }
}
