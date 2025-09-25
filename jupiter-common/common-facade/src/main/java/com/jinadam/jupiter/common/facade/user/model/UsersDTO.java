package com.jinadam.jupiter.common.facade.user.model;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Adam
 * 2025-09-04 12:34
 */

@Data
public class UsersDTO implements Serializable {
    /**
     * 用户主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 密钥
     */
    private String secret;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String gender;

    /**
     * 上次登陆时间
     */
    private LocalDateTime lastLogin;

    /**
     * 上次访问时间
     */
    private LocalDateTime lastAccess;

    /**
     * 隐私等级：low 低， normal0 正常，strong 强
     */
    private String privacy;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 上传量
     */
    private Long uploaded;

    /**
     * 下载量
     */
    private Long downloaded;

    /**
     * 做种时间
     */
    private Long seedTime;

    /**
     * 吸血时间
     */
    private Long leechTime;

    /**
     * 国家编码
     */
    private String country;

    /**
     * 种子密钥
     */
    private String passkey;

    /**
     * 邀请人
     */
    private Long inviter;

    /**
     * 永久邀请个数
     */
    private Long inviteNum;

    /**
     * 做种魔力
     */
    private BigDecimal seedBonus;

    /**
     * 做种积分
     */
    private BigDecimal seedPoints;

    /**
     * 时魔
     */
    private BigDecimal bonusPerHour;

    /**
     * 时积分
     */
    private BigDecimal pointsPerHour;

    /**
     * 二次验证
     */
    private String totp;

    /**
     * 个人简介
     */
    private String info;

    /**
     * 状态：pending 待确认，confirmed 确认，banned 被禁用
     */
    private String status;

    /**
     * 加入时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
