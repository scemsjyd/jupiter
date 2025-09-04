package com.jinadam.jupiter.api.main.auth.controller;


import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.jinadam.jupiter.api.main.auth.req.LoginReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam
 * 2025-09-03 12:52
 */
@Tag(name = "认证接口")
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Operation(summary = "登陆")
    @PostMapping("/login")
    @SaIgnore
    public Boolean login(@RequestBody LoginReq req, HttpServletResponse response) {
        StpUtil.login(1);
        return true;
    }
}
