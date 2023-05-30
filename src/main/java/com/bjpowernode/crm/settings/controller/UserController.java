package com.bjpowernode.crm.settings.controller;

import com.bjpowernode.crm.commons.utils.DateUtil;
import com.bjpowernode.crm.commons.utils.Result;
import com.bjpowernode.crm.commons.utils.UUIDUtil;
import com.bjpowernode.crm.settings.entity.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.settings.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "User接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据id查询")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id){
        User user = userService.selectById(id);
//        System.out.println(user);
        return Result.ok(user);
    }

    @ApiOperation("条件查询带分页")
    @GetMapping("page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNumber,
                       @RequestParam(defaultValue = "5")Integer pageSize,
                       User user){
        Map<String, Object> map = userService.select(pageNumber, pageSize, user);
        return Result.ok(map);
    }

    @ApiOperation("添加用户")
    @PostMapping("save")
    public Result save(@RequestBody User user, HttpSession session){
        User loginAct = userService.selectByLoginAct(user.getLoginAct());
        if (loginAct != null){
            return Result.fail(null).message("该账户已存在");
        }

        User loginUser = (User) session.getAttribute("loginUser");
        user.setId(UUIDUtil.getUUID());
        user.setCreateTime(DateUtil.dateToString(new Date()));
        user.setEditTime(DateUtil.dateToString(new Date()));
        user.setCreateBy(loginUser.getLoginAct());
        user.setEditBy(loginUser.getLoginAct());

        userService.insert(user);
        return Result.ok(null);
    }

    @ApiOperation("修改用户")
    @PutMapping("edit")
    public Result edit(@RequestBody User user, HttpSession session){
        User loginUser = (User) session.getAttribute("loginUser");
        user.setEditBy(loginUser.getLoginAct());
        user.setEditTime(DateUtil.dateToString(new Date()));

        userService.update(user);
        return Result.ok(null);
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result removeById(@PathVariable String id){
        userService.deleteById(id);
        return Result.ok(null);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("removeBatch")
    public Result removeBatch(String[] ids){
        userService.deleteBatch(ids);
        return Result.ok(null);
    }

    @Autowired
    private UserMapper userMapper;

    @GetMapping("test")
    public Result test(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","迈克");
        List<User> userList = userMapper.selectByMap(map);
        return Result.ok(userList);
    }


}
