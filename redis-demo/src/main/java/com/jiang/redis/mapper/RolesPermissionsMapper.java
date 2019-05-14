package com.jiang.redis.mapper;

import com.jiang.redis.entity.Permission;
import com.jiang.redis.entity.RolesPermissionsKey;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RolesPermissionsMapper {
    int deleteByPrimaryKey(RolesPermissionsKey key);

    int insert(RolesPermissionsKey record);

    int insertSelective(RolesPermissionsKey record);

    Set<Permission> getPermissionByRoleid(@Param("roleid") Integer id);
}