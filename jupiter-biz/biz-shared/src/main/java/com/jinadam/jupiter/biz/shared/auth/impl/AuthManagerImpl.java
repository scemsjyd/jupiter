package com.jinadam.jupiter.biz.shared.auth.impl;


import cn.dev33.satoken.model.wrapperInfo.SaDisableWrapperInfo;
import cn.dev33.satoken.stp.StpInterface;
import com.jinadam.jupiter.biz.shared.auth.AuthManager;
import com.jinadam.jupiter.core.service.auth.AuthService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Adam
 * 2025-09-05 12:57
 */
@Service
@Slf4j
public class AuthManagerImpl implements AuthManager, StpInterface {

    @Resource
    AuthService authService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        log.debug("get permission list");
        return List.of();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        log.debug("get role list");
        return List.of();
    }

    @Override
    public SaDisableWrapperInfo isDisabled(Object loginId, String service) {
        log.debug("is disabled");
        return StpInterface.super.isDisabled(loginId, service);
    }

    @Override
    public boolean validate(String username, String password) {
        return authService.validate(username, password);
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return authService.changePassword(username, oldPassword, newPassword);
    }
}
