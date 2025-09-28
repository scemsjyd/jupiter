package com.jinadam.jupiter.api.main.auth.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.jinadam.jupiter.api.main.auth.req.ChangePasswordReq;
import com.jinadam.jupiter.api.main.auth.req.LoginReq;
import com.jinadam.jupiter.api.main.auth.resp.LoginResp;
import com.jinadam.jupiter.common.facade.auth.AuthFacade;
import com.jinadam.jupiter.common.util.constants.ErrorCode;
import com.jinadam.jupiter.common.util.exception.AuthException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
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
@SaCheckLogin
public class LoginController {

    @Resource
    private AuthFacade authFacade;

    @Operation(summary = "登陆")
    @PostMapping("/login")
    @SaIgnore
    public LoginResp login(@RequestBody LoginReq req, HttpServletResponse response) {
        boolean result = authFacade.validate(req.getUsername(), req.getPassword());
        if (result) {
            StpUtil.login(1);
            // 第2步，获取 Token  相关参数
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            // 第3步，返回给前端
            return LoginResp.builder().tokenName(tokenInfo.getTokenName()).tokenValue(tokenInfo.getTokenValue()).build();
        }
        throw new AuthException(ErrorCode.AUTH.FAIL);
    }

    @Operation(summary = "退出登陆")
    @GetMapping("/logout")
    public Boolean logout() {
        StpUtil.logout();
        return true;
    }

    @Operation(summary = "修改密码")
    @GetMapping("/change-password")
    public Boolean changePassword(@RequestBody ChangePasswordReq req) {
        boolean bool = authFacade.changePassword(req.getUsername(), req.getOldPassword(), req.getNewPassword());
        if (bool) {
            StpUtil.logout();
            return true;
        }
        return false;
    }

    @Operation(summary = "重置密码")
    @GetMapping("/reset-password")
    public Boolean resetPassword(@RequestBody ChangePasswordReq req) {
        boolean bool = authFacade.changePassword(req.getUsername(), req.getOldPassword(), req.getNewPassword());
        if (bool) {
            StpUtil.logout();
            return true;
        }
        return false;
    }

}
