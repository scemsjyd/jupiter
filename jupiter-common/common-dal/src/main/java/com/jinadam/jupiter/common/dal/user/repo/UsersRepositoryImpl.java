package com.jinadam.jupiter.common.dal.user.repo;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.jinadam.jupiter.common.dal.user.converter.UsersCoreConverter;
import com.jinadam.jupiter.common.dal.user.mapper.UsersMapper;
import com.jinadam.jupiter.common.dal.user.model.UsersPO;
import com.jinadam.jupiter.core.model.user.UsersEntity;
import com.jinadam.jupiter.core.service.user.repo.UsersRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @author Adam
 * 2025-09-05 17:05
 */
@Repository
public class UsersRepositoryImpl implements UsersRepository {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UsersEntity findByUsername(String username) {
        LambdaQueryWrapper<UsersPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UsersPO::getUsername, username);
        UsersPO usersPo = usersMapper.selectOne(queryWrapper);
        return UsersCoreConverter.INSTANCE.toS(usersPo);
    }

    @Override
    public void updatePasswordById(String newPassMd5, Long id) {
        LambdaUpdateWrapper<UsersPO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UsersPO::getId, id);
        updateWrapper.set(UsersPO::getPassword, newPassMd5);
        usersMapper.update(null, updateWrapper);
    }

    @Override
    public UsersEntity findById(Long id) {
        UsersPO po = usersMapper.selectById(id);
        return UsersCoreConverter.INSTANCE.toS(po);
    }
}
