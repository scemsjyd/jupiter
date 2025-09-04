package com.jinadam.jupiter.api.main.auth.req;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Adam
 * 2025-09-04 20:10
 */
@Data
public class LoginReq {
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码md5")
    private String password;
}
