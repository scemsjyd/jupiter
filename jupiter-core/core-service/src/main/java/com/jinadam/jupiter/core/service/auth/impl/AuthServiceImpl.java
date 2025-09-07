package com.jinadam.jupiter.core.service.auth.impl;


import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.jinadam.jupiter.common.util.constants.ErrorCode;
import com.jinadam.jupiter.common.util.exception.AuthException;
import com.jinadam.jupiter.common.util.exception.BizException;
import com.jinadam.jupiter.core.model.user.UsersEntity;
import com.jinadam.jupiter.core.service.auth.AuthService;
import com.jinadam.jupiter.core.service.user.repo.UsersRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Adam
 * 2025-09-05 16:45
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    UsersRepository usersRepository;

    @Override
    public boolean validate(String username, String password) {
        UsersEntity usersEntity = usersRepository.findByUsername(username);
        if (Objects.isNull(usersEntity)) {
            return false;
        }
        if (StrUtil.isBlank(usersEntity.getPassword())) {
            throw new AuthException(ErrorCode.AUTH.NO_PASS);
        }
        String secret = usersEntity.getSecret();
        String md5Pass = DigestUtil.md5Hex(secret + password + secret);
        if (usersEntity.getPassword().equals(md5Pass)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        UsersEntity usersEntity = usersRepository.findByUsername(username);
        if (Objects.isNull(usersEntity)) {
            throw new BizException(ErrorCode.BIZ.USERNAME_NOT_EXIST);
        }
        String secret = usersEntity.getSecret();
        String oldPassMd5 = DigestUtil.md5Hex(secret + oldPassword + secret);
        if (usersEntity.getPassword().equals(oldPassMd5)) {
            // 密码正确，修改密码
            String newPassMd5 = DigestUtil.md5Hex(secret + newPassword + secret);
            usersRepository.updatePasswordById(newPassMd5, usersEntity.getId());
            return true;
        }
        return false;
    }
}
