package com.jinadam.jupiter.biz.shared.auth;


/**
 * @author Adam
 * 2025-09-05 12:56
 */
public interface AuthManager {
    boolean validate(String username, String password);

    boolean changePassword(String username, String oldPassword, String newPassword);
}
