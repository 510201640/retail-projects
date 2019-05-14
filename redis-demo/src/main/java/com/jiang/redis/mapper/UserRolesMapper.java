package com.jiang.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiang.redis.entity.Roles;
import com.jiang.redis.entity.UserRolesKey;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface UserRolesMapper {
    int deleteByPrimaryKey(UserRolesKey key);

    int insert(UserRolesKey record);

    int insertSelective(UserRolesKey record);

    Set<Roles> getRolesByUserid(@Param("userid") Integer id);
}