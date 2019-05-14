package com.jiang.redis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiang.redis.entity.Permission;
import com.jiang.redis.entity.Roles;
import com.jiang.redis.entity.Users;
import com.jiang.redis.mapper.RolesPermissionsMapper;
import com.jiang.redis.mapper.UserRolesMapper;
import com.jiang.redis.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/13
 */
@Service
public class UserServiceImpl {


    @Resource
    private UserRolesMapper userRolesMapper;

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private RolesPermissionsMapper rolesPermissionsMapper;
    /**
     * 通过用户名查询用户所有的角色
     * @param id
     * @return
     */
    public Set<Roles> getRolesByUserid(Integer id){
        return userRolesMapper.getRolesByUserid(id);
    }


    /**
     * 通过角色id获取该角色所有的权限列表
     * @param id
     * @return
     */
    public Set<Permission> getPermissionByRoleid(Integer id){
        return rolesPermissionsMapper.getPermissionByRoleid(id);
    }
    public Users getUsersByUsername(String userName){
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",userName);
        return usersMapper.selectOne(wrapper);
    }

    public Users getUsersByUserid(Integer userid){
        return usersMapper.selectByPrimaryKey(userid.longValue());
    }

}
