-- 创建序列
-- CREATE SEQUENCE seq_user_id INCREMENT BY 1 START WITH 10000001 CACHE 1;
-- 创建updated_at自动更新的触发函数
CREATE OR REPLACE FUNCTION set_updated_at()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.updated_at := NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- 创建表
-- 创建用户表
DROP TABLE IF EXISTS t_users;
create table t_users
(
    id              bigserial      not null,
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
    deleted         int4           not null default 0,
    version         int8           not null default 1,
    created_by      int8           null,
    updated_by      int8           null,
    created_at      timestamp      null     default now(),
    updated_at      timestamp      null     default now(),
    primary key (id)
);

ALTER SEQUENCE t_users_id_seq RESTART WITH 10000001 INCREMENT BY 1 CACHE 1;

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
comment on column users.deleted is '逻辑删除标志，0 正常，1 删除';
comment on column users.version is '版本号';
comment on column users.created_by is '创建者ID';
comment on column users.updated_by is '更新者ID';
comment on column users.created_at is '加入时间';
comment on column users.updated_at is '更新时间';

CREATE OR REPLACE TRIGGER trigger_set_updated_at
    BEFORE UPDATE
    ON users
    FOR EACH ROW
EXECUTE FUNCTION set_updated_at();
-- 创建用户表结束

-- 初始化超级管理员信息
DO
$$
    DECLARE
        v_secret   TEXT;
        v_password TEXT := 'password';
    BEGIN
        v_secret := (SELECT STRING_AGG(
                                    substr('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789',
                                           floor(random() * 62 + 1)::int, 1), ''
                            ) AS random_str
                     FROM generate_series(1, 16));

        INSERT INTO public.users
        (id, username, "password", secret, email, gender, last_login, last_access, privacy, avatar, uploaded,
         downloaded, seed_time, leech_time, country, passkey, inviter, invite_num, seed_bonus, seed_points,
         bonus_per_hour, points_per_hour, totp, info, status, deleted, version, created_by, updated_by, created_at,
         updated_at)
        VALUES (1, 'admin', md5(concat(v_secret, md5(v_password), v_secret)), v_secret, '', 'male', now(), now(),
                'normal'::character varying, '', 0, 0, 0, 0, '', md5(v_secret), 0, 0, 0, 0, 0, 0, '', '', 'confirmed',
                0, 1, 0, 0, now(), now());
    END;
$$;


