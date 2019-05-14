package com.jiang.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiang.redis.entity.Users;

public interface UsersMapper extends BaseMapper<Users> {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}