package com.jiang.redis.controller;

import com.jiang.redis.service.RedisService;
import com.jiang.redis.service.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/7
 */
@Controller
@Log4j2
public class TestController {
   /* @Autowired
    private RedisService redisService;
*/
    @Autowired
    private UserServiceImpl userService;

  /*  @GetMapping("/test1")
    public Object getUsers(){
        Object s = redisService.findAllUsers();
        System.err.println(s);
        return s;
    }*/

    @GetMapping("roles/{userid}")
    public @ResponseBody Object getUserRoles(@PathVariable("userid") Integer userid){
        SecurityUtils.getSubject().checkPermissions("123");
        log.error("用户id为:{}发起了请求",userid);
         return   userService.getRolesByUserid(userid);
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        map.put("msg", exception);
        // 此方法不处理登录成功,由shiro进行处理
        return "login";
    }



    @GetMapping("/test2")
    public Map<String,Object> getMaps(@RequestBody Map<String,Object> map){

        return map;
    }

   /* @GetMapping("/test")
    public Object get(){
        Object s = redisService.findUsers();
        System.err.println(s);
        return s;
    }*/
}
