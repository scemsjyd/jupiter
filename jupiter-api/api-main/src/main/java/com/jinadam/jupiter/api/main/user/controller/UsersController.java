package com.jinadam.jupiter.api.main.user.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.jinadam.jupiter.api.main.user.converter.UserApiConverter;
import com.jinadam.jupiter.api.main.user.resp.UsersResp;
import com.jinadam.jupiter.biz.shared.user.UsersManager;
import com.jinadam.jupiter.common.facade.user.model.UsersDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam
 * 2025-09-03 12:52
 */
@Tag(name = "用户")
@RestController
@RequestMapping("/user")
@SaCheckLogin
public class UsersController {

    @Resource
    private UsersManager usersManager;

    @Operation(summary = "当前用户信息")
    @GetMapping("/profile")
    @SaCheckPermission(value = {"user.profile"})
    public UsersResp findById() {
        UsersDTO usersDTO = usersManager.findById(1L);
        return UserApiConverter.INSTANCE.toS(usersDTO);
    }
}
