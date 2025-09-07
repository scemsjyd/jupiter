package com.jinadam.jupiter.api.main.auth.req;

import lombok.Data;

/**
 * @author Adam
 * 2025-09-06 11:25
 */
@Data
public class ChangePasswordReq {
    /**
     * 用户名
     */
    private String username;
    /**
     * 旧密码
     */
    private String oldPassword;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 新的确认密码
     */
    private String confirmPassword;
}