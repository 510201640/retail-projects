package com.jiang.redis.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/7
 */
@Service
@CacheConfig(cacheNames = "entity")
public class RedisService {

  /*  @Resource
    private UserMapper userMapper;

    @Cacheable("user_cache")
    public Object findUsers(){
        System.err.println("不走缓存...");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        return  users;
    }


    *//**
     * 查询所有的用户
     * @return 返回所有的用户
     *//*
    public Object findAllUsers(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        return  users;
    }
*/






}
