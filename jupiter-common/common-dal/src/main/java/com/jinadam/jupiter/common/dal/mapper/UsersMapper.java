package com.jinadam.jupiter.common.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jinadam.jupiter.common.dal.model.UsersPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Adam
 */
@Mapper
public interface UsersMapper extends BaseMapper<UsersPO> {
}