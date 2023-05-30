package com.bjpowernode.crm.settings.controller;

import com.bjpowernode.crm.commons.utils.DateUtil;
import com.bjpowernode.crm.commons.utils.Result;
import com.bjpowernode.crm.settings.entity.User;
import com.bjpowernode.crm.settings.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Api(tags = "登录接口")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录方法")
    @GetMapping("/login")
    public Result login(String loginAct, String pwd, HttpSession session){
        User user = userService.login(loginAct, pwd);
        System.out.println(user+"========================================");
        if (user == null){
            return Result.fail(null).message("账号或密码错误!");
        }
        if ("0".equals(user.getLockState())){
            return Result.fail(null).message("该账号已锁定,请联系管理员!");
        }
        if (StringUtils.hasLength(user.getExpireTime()) &&
                new Date().compareTo(DateUtil.stringToDate(user.getExpireTime()))>0){
            return Result.fail(null).message("该账号已过期,请联系管理员!");
        }
        session.setAttribute("loginUser", user);
        return Result.ok(null);
    }

    @ApiOperation("退出方法")
    @GetMapping("/logout")
    public Result logout(HttpSession session){
        session.removeAttribute("loginUser");
        session.invalidate();
        return Result.ok(null);
    }


}
