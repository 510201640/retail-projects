package com.jiang.redis.shiro;

import com.jiang.redis.entity.Permission;
import com.jiang.redis.entity.Roles;
import com.jiang.redis.entity.Users;
import com.jiang.redis.service.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/13
 */
@Log4j2
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<Roles> roles = userService.getRolesByUserid(userService.getUsersByUsername(userName).getId().intValue());
        if(Objects.isNull(roles)){
            return null;
        }
        Set<String> roleNames  = roles.stream().map(role -> role.getRolename()).collect(Collectors.toSet());

        info.setRoles(roleNames);
        Set<String> permissions = new HashSet<>();
        roles.stream().forEach(role -> {
            Set<Permission> permission = userService.getPermissionByRoleid(role.getId().intValue());

            permissions.addAll( permission.stream().map(p -> p.getPermissionname()).collect(Collectors.toSet()));
        });
        if(Objects.isNull(permissions)){
            return null;
        }
        info.setStringPermissions(permissions);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        Users user = userService.getUsersByUsername(userName);
       AuthenticationInfo info = new SimpleAccount();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
               null,//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
