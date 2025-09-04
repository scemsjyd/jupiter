package com.jinadam.jupiter.common.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * 用户表
 *
 * @author Adam
 */
@Data
@TableName(value = "users")
public class UsersPO {
    /**
     * 用户主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 密钥
     */
    @TableField(value = "secret")
    private String secret;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 上次登陆时间
     */
    @TableField(value = "last_login")
    private LocalDateTime lastLogin;

    /**
     * 上次访问时间
     */
    @TableField(value = "last_access")
    private LocalDateTime lastAccess;

    /**
     * 隐私等级：low 低， normal0 正常，strong 强
     */
    @TableField(value = "privacy")
    private String privacy;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 上传量
     */
    @TableField(value = "uploaded")
    private Long uploaded;

    /**
     * 下载量
     */
    @TableField(value = "downloaded")
    private Long downloaded;

    /**
     * 做种时间
     */
    @TableField(value = "seed_time")
    private Long seedTime;

    /**
     * 吸血时间
     */
    @TableField(value = "leech_time")
    private Long leechTime;

    /**
     * 国家编码
     */
    @TableField(value = "country")
    private String country;

    /**
     * 种子密钥
     */
    @TableField(value = "passkey")
    private String passkey;

    /**
     * 邀请人
     */
    @TableField(value = "inviter")
    private Long inviter;

    /**
     * 永久邀请个数
     */
    @TableField(value = "invite_num")
    private Long inviteNum;

    /**
     * 做种魔力
     */
    @TableField(value = "seed_bonus")
    private BigDecimal seedBonus;

    /**
     * 做种积分
     */
    @TableField(value = "seed_points")
    private BigDecimal seedPoints;

    /**
     * 时魔
     */
    @TableField(value = "bonus_per_hour")
    private BigDecimal bonusPerHour;

    /**
     * 时积分
     */
    @TableField(value = "points_per_hour")
    private BigDecimal pointsPerHour;

    /**
     * 二次验证
     */
    @TableField(value = "totp")
    private String totp;

    /**
     * 个人简介
     */
    @TableField(value = "info")
    private String info;

    /**
     * 状态：pending 待确认，confirmed 确认，banned 被禁用
     */
    @TableField(value = "status")
    private String status;

    /**
     * 加入时间
     */
    @TableField(value = "added")
    private LocalDateTime added;
}