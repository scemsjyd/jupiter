-- 创建序列
CREATE SEQUENCE user_id_seq INCREMENT BY 1 START WITH 10000001 CACHE 1;

-- 创建表
-- 创建用户表
create table users
(
    id              int8           not null default nextval('user_id_seq'),
    username        varchar        not null,
    password        varchar        not null,
    secret          varchar        not null,
    email           varchar        not null,
    gender          varchar        null,
    last_login      timestamp      null,
    last_access     timestamp      null,
    privacy         varchar        not null default 'normal',
    avatar          varchar        null,
    uploaded        int8           null,
    downloaded      int8           null,
    seed_time       int8           null,
    leech_time      int8           null,
    country         varchar        null,
    passkey         varchar        not null,
    inviter         int8           null,
    invite_num      int8           null     default 0,
    seed_bonus      decimal(20, 2) null     default 0,
    seed_points     decimal(20, 2) null     default 0,
    bonus_per_hour  decimal(20, 2) null     default 0,
    points_per_hour decimal(20, 2) null     default 0,
    totp            varchar        null,
    info            text           null,
    status          varchar        null     default 'pending',
    added           timestamp      null     default now(),
    primary key (id)
);

comment on table users is '用户表';
comment on column users.id is '用户主键';
comment on column users.username is '用户名';
comment on column users.password is '用户密码';
comment on column users.secret is '密钥';
comment on column users.email is '邮箱';
comment on column users.gender is '性别';
comment on column users.last_login is '上次登陆时间';
comment on column users.last_access is '上次访问时间';
comment on column users.privacy is '隐私等级：low 低， normal 正常，strong 强';
comment on column users.avatar is '头像';
comment on column users.uploaded is '上传量';
comment on column users.downloaded is '下载量';
comment on column users.seed_time is '做种时间';
comment on column users.leech_time is '吸血时间';
comment on column users.country is '国家编码';
comment on column users.passkey is '种子密钥';
comment on column users.inviter is '邀请人';
comment on column users.invite_num is '永久邀请个数';
comment on column users.seed_bonus is '做种魔力';
comment on column users.seed_points is '做种积分';
comment on column users.bonus_per_hour is '时魔';
comment on column users.points_per_hour is '时积分';
comment on column users.totp is '二次验证';
comment on column users.info is '个人简介';
comment on column users.status is '状态：pending 待确认，confirmed 确认，banned 被禁用';
comment on column users.added is '加入时间';

-- 创建用户表结束