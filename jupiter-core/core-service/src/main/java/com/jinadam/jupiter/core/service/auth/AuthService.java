package com.jinadam.jupiter.core.service.auth;


/**
 * @author Adam
 * 2025-09-05 16:44
 */
public interface AuthService {
    boolean validate(String username, String password);

    boolean changePassword(String username, String oldPassword, String newPassword);

}
