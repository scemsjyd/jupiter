-- 创建种子分类表
CREATE TABLE t_category
(
    id         int8,
    pid        int8               default 0,
    code       TEXT,
    name       TEXT,
    image      TEXT,
    sort       int4,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);
COMMENT ON TABLE t_category IS '种子分类表';
COMMENT ON COLUMN t_category.id IS '分类ID';
COMMENT ON COLUMN t_category.pid IS '父分类ID，0表示顶级分类';
COMMENT ON COLUMN t_category.code IS '分类英文名称';
COMMENT ON COLUMN t_category.name IS '分类中文名称';
COMMENT ON COLUMN t_category.image IS '分类图标URL';
COMMENT ON COLUMN t_category.sort IS '分类排序索引，数值越小越靠前';
COMMENT ON COLUMN t_category.created_at IS '创建时间';
COMMENT ON COLUMN t_category.updated_at IS '最后更新时间';

-- 初始化分类
INSERT INTO t_category (id, pid, name, image, sort)
VALUES (1, 0, '电影', '/images/category/movie.png', 1),
       (2, 0, '电视剧', '/images/category/tv.png', 2),
       (3, 0, '综艺', '/images/category/variety.png', 3),
       (4, 0, '动漫', '/images/category/anime.png', 4),
       (5, 0, '纪录片', '/images/category/documentary.png', 5),
       (6, 0, '音乐', '/images/category/music.png', 6),
       (7, 0, '游戏', '/images/category/game.png', 7),
       (8, 0, '软件', '/images/category/software.png', 8),
       (9, 0, '其他', '/images/category/other.png', 9);
-- 创建种子信息表
CREATE TABLE t_torrents
(
    id                  int8                                                                       NOT NULL,
    info_hash           TEXT,
    name                TEXT,
    filename            TEXT,
    cover               TEXT,
    descr               TEXT,
    subtitle            TEXT,
    ori_descr           TEXT,
    category            int4,
    source              int4,
    medium              int4,
    codec               int4,
    standard            int4,
    processing          int4,
    team                int4,
    audiocodec          int4,
    size                int8,
    added               datetime                                                                            DEFAULT NULL,
    type                enum('single', 'multi') COLLATE utf8mb4_unicode_ci                         NOT NULL DEFAULT 'single',
    numfiles            smallint(5) unsigned                                                        NOT NULL DEFAULT '0',
    comments            mediumint(8) unsigned                                                       NOT NULL DEFAULT '0',
    views               int(10) unsigned                                                            NOT NULL DEFAULT '0',
    hits                int(10) unsigned                                                            NOT NULL DEFAULT '0',
    times_completed     mediumint(8) unsigned                                                       NOT NULL DEFAULT '0',
    leechers            mediumint(8) unsigned                                                       NOT NULL DEFAULT '0',
    seeders             mediumint(8) unsigned                                                       NOT NULL DEFAULT '0',
    last_action         datetime                                                                            DEFAULT NULL,
    visible             enum('yes', 'no') COLLATE utf8mb4_unicode_ci                               NOT NULL DEFAULT 'yes',
    banned              enum('yes', 'no') COLLATE utf8mb4_unicode_ci                               NOT NULL DEFAULT 'no',
    owner               mediumint(8) unsigned                                                       NOT NULL DEFAULT '0',
    nfo                 blob,
    sp_state            tinyint(3) unsigned                                                         NOT NULL DEFAULT '1',
    promotion_time_type int4,
    promotion_until     datetime                                                                            DEFAULT NULL,
    anonymous           enum('yes', 'no') COLLATE utf8mb4_unicode_ci                               NOT NULL DEFAULT 'no',
    url                 int(10) unsigned                                                                     DEFAULT NULL,
    pos_state           varchar(32) COLLATE utf8mb4_unicode_ci                                     NOT NULL DEFAULT 'normal',
    pos_state_until     datetime                                                                            DEFAULT NULL,
    cache_stamp         int4,
    picktype            enum('hot', 'classic', 'recommended', 'normal') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'normal',
    picktime            datetime                                                                            DEFAULT NULL,
    last_reseed         datetime                                                                            DEFAULT NULL,
    pt_gen              mediumtext COLLATE utf8mb4_unicode_ci,
    technical_info      text COLLATE utf8mb4_unicode_ci,
    hr                  tinyint(4)                                                                 NOT NULL DEFAULT '0',
    approval_status     int(11)                                                                     NOT NULL DEFAULT '0',
    price               int(11)                                                                     NOT NULL DEFAULT '0',
    offers              enum('yes', 'no') COLLATE utf8mb4_unicode_ci                               NOT NULL DEFAULT 'no',
    pieces_hash         char(40) COLLATE utf8mb4_unicode_ci                                        NOT NULL DEFAULT '',
    PRIMARY KEY (id),
    UNIQUE KEY info_hash (info_hash),
    KEY                 visible_pos_id(visible, pos_state, id),
    KEY                 category_visible_banned(category, visible, banned),
    KEY                 visible_banned_pos_id(visible, banned, pos_state, id),
    KEY                 name(name),
    KEY                 owner(owner),
    KEY                 url(url),
    KEY                 torrents_pieces_hash_index(pieces_hash)
) ENGINE = InnoDB
  AUTO_INCREMENT = 29949
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
COMMENT ON TABLE t_torrents IS '种子信息表';
COMMENT ON COLUMN t_torrents.id IS '种子ID';
COMMENT ON COLUMN t_torrents.info_hash IS '种子hash值';
COMMENT ON COLUMN t_torrents.name IS '种子名称';
COMMENT ON COLUMN t_torrents.filename IS '种子文件名';
-- COMMENT ON COLUMN t_torrents.save_as IS '保存的文件名';
COMMENT ON COLUMN t_torrents.cover IS '封面图片';
COMMENT ON COLUMN t_torrents.descr IS '种子描述';
COMMENT ON COLUMN t_torrents.subtitle IS '种子副标题';
COMMENT ON COLUMN t_torrents.ori_descr IS '种子原始描述';
COMMENT ON COLUMN t_torrents.category IS '分类ID';
COMMENT ON COLUMN t_torrents.source IS '来源';
COMMENT ON COLUMN t_torrents.medium IS '介质';
COMMENT ON COLUMN t_torrents.codec IS '视频编码';
COMMENT ON COLUMN t_torrents.standard IS '视频标准';
COMMENT ON COLUMN t_torrents.processing IS '后期处理';
COMMENT ON COLUMN t_torrents.team IS '发布组';
COMMENT ON COLUMN t_torrents.audiocodec IS '音频编码';
COMMENT ON COLUMN t_torrents.size IS '文件大小';
COMMENT ON COLUMN t_torrents.added IS '添加时间';
COMMENT ON COLUMN t_torrents.type IS '种子类型，单文件single或多文件multi';
COMMENT ON COLUMN t_torrents.numfiles IS '文件数量';
COMMENT ON COLUMN t_torrents.comments IS '评论数量';
COMMENT ON COLUMN t_torrents.views IS '查看次数';
COMMENT ON COLUMN t_torrents.hits IS '点击次数';
COMMENT ON COLUMN t_torrents.times_completed IS '完成次数';
COMMENT ON COLUMN t_torrents.leechers IS '当前下载者数量';
COMMENT ON COLUMN t_torrents.seeders IS '当前做种者数量';
COMMENT ON COLUMN t_torrents.last_action IS '最后活动时间';
COMMENT ON COLUMN t_torrents.visible IS '是否可见';
COMMENT ON COLUMN t_torrents.banned IS '是否被禁止';
COMMENT ON COLUMN t_torrents.owner IS '发布者用户ID';
COMMENT ON COLUMN t_torrents.nfo IS 'NFO信息';
COMMENT ON COLUMN t_torrents.sp_state IS '超级种子状态，0表示不是超级种子，1表示普通超级种子，2表示黄金超级种子';
COMMENT ON COLUMN t_torrents.promotion_time_type IS '促销时间类型，0表示无促销，1表示1天，2表示3天，3表示7天，4表示15天，5表示30天';
COMMENT ON COLUMN t_torrents.promotion_until IS '促销结束时间';
COMMENT ON COLUMN t_torrents.anonymous IS '是否匿名发布';
COMMENT ON COLUMN t_torrents.url IS '外链URL ID';
COMMENT ON COLUMN t_torrents.pos_state IS '置顶状态，normal表示正常，top表示置顶，super表示超级置顶';
COMMENT ON COLUMN t_torrents.pos_state_until IS '置顶状态结束时间';
COMMENT ON COLUMN t_torrents.cache_stamp IS '缓存标记，用于缓存管理';
COMMENT ON COLUMN t_torrents.picktype IS '精选类型，hot表示热门，classic表示经典，recommended表示推荐，normal表示普通';
COMMENT ON COLUMN t_torrents.picktime IS '被选为精选的时间';
COMMENT ON COLUMN t_torrents.last_reseed IS '最后重新做种时间';
COMMENT ON COLUMN t_torrents.pt_gen IS 'PT生成信息';
COMMENT ON COLUMN t_torrents.technical_info IS '技术信息，如分辨率、码率等';
COMMENT ON COLUMN t_torrents.hr IS '高清资源标记，0表示非高清，1表示高清';
COMMENT ON COLUMN t_torrents.approval_status IS '审核状态，0表示未审核，1表示已审核';
COMMENT ON COLUMN t_torrents.price IS '种子价格，单位为积分';
COMMENT ON COLUMN t_torrents.offers IS '是否允许还价';
COMMENT ON COLUMN t_torrents.pieces_hash IS '分块哈希值，用于验证数据完整性';