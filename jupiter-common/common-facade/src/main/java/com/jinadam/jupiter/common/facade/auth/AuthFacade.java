package com.jinadam.jupiter.common.facade.auth;


/**
 * @author Adam
 * 2025-09-05 16:35
 */
public interface AuthFacade {
    boolean validate(String username, String password);

    boolean changePassword(String username, String oldPassword, String newPassword);
}
