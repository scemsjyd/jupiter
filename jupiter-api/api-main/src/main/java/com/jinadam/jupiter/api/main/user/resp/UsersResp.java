package com.jinadam.jupiter.api.main.user.resp;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Adam
 * 2025-09-04 12:49
 */
@Data
public class UsersResp {
    /**
     * 用户主键
     */
    @Schema(description = "用户主键")
    private Long id;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 性别
     */
    @Schema(description = "性别")
    private String gender;

    /**
     * 上次登陆时间
     */
    @Schema(description = "上次登陆时间")
    private LocalDateTime lastLogin;

    /**
     * 上次访问时间
     */
    @Schema(description = "上次访问时间")
    private LocalDateTime lastAccess;

    /**
     * 隐私等级：low 低， normal0 正常，strong 强
     */
    @Schema(description = "隐私等级：low 低， normal0 正常，strong 强")
    private String privacy;

    /**
     * 头像
     */
    @Schema(description = "头像")
    private String avatar;

    /**
     * 上传量
     */
    @Schema(description = "上传量")
    private Long uploaded;

    /**
     * 下载量
     */
    @Schema(description = "下载量")
    private Long downloaded;

    /**
     * 做种时间
     */
    @Schema(description = "做种时间")
    private Long seedTime;

    /**
     * 吸血时间
     */
    @Schema(description = "吸血时间")
    private Long leechTime;

    /**
     * 国家编码
     */
    @Schema(description = "国家编码")
    private String country;

    /**
     * 邀请人
     */
    @Schema(description = "邀请人")
    private Long inviter;

    /**
     * 永久邀请个数
     */
    @Schema(description = "永久邀请个数")
    private Long inviteNum;

    /**
     * 做种魔力
     */
    @Schema(description = "做种魔力")
    private BigDecimal seedBonus;

    /**
     * 做种积分
     */
    @Schema(description = "做种积分")
    private BigDecimal seedPoints;

    /**
     * 时魔
     */
    @Schema(description = "时魔")
    private BigDecimal bonusPerHour;

    /**
     * 时积分
     */
    @Schema(description = "时积分")
    private BigDecimal pointsPerHour;

    /**
     * 个人简介
     */
    @Schema(description = "个人简介")
    private String info;

    /**
     * 状态：pending 待确认，confirmed 确认，banned 被禁用
     */
    @Schema(description = "状态：pending 待确认，confirmed 确认，banned 被禁用")
    private String status;

    /**
     * 加入时间
     */
    @Schema(description = "加入时间")
    private LocalDateTime added;
}
