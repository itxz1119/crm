package com.bjpowernode.crm.workbench.controller;

import com.bjpowernode.crm.commons.utils.DateUtil;
import com.bjpowernode.crm.commons.utils.Result;
import com.bjpowernode.crm.commons.utils.UUIDUtil;
import com.bjpowernode.crm.settings.entity.User;
import com.bjpowernode.crm.workbench.entity.ActivityRemark;
import com.bjpowernode.crm.workbench.service.ActivityRemarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Api(tags = "备注接口")
@RestController
@RequestMapping("/activityRemark")
public class ActivityRemarkController {
    @Autowired
    private ActivityRemarkService activityRemarkService;

    @ApiOperation("根据id获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable String id){
        return Result.ok(activityRemarkService.selectByPrimaryKey(id));
    }

    @ApiOperation("查询全部")
    @GetMapping("list")
    public Result list(ActivityRemark activityRemark){
        return Result.ok(activityRemarkService.select(activityRemark));
    }

    @ApiOperation("添加")
    @PostMapping("save")
    public Result save(@RequestBody ActivityRemark activityRemark, HttpSession session){
        //        create_time, create_by
//                , edit_time, edit_by
        User loginUser = (User) session.getAttribute("loginUser");
        activityRemark.setId(UUIDUtil.getUUID());
        activityRemark.setEditFlag("0");
        activityRemark.setCreateBy(loginUser.getLoginAct());
        activityRemark.setEditBy(loginUser.getLoginAct());
        activityRemark.setCreateTime(DateUtil.dateToString(new Date()));
        activityRemark.setEditTime(DateUtil.dateToString(new Date()));
        int insert = activityRemarkService.insert(activityRemark);
        return Result.ok(insert);
    }

    @ApiOperation("修改")
    @PutMapping("edit")
    public Result edit(@RequestBody ActivityRemark activityRemark, HttpSession session){
        User loginUser = (User) session.getAttribute("loginUser");
        activityRemark.setEditFlag("1");
        activityRemark.setEditBy(loginUser.getLoginAct());
        activityRemark.setEditTime(DateUtil.dateToString(new Date()));
        return Result.ok(activityRemarkService.updateByPrimaryKeySelective(activityRemark));
    }

    @ApiOperation("删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id){
        return Result.ok(activityRemarkService.deleteByPrimaryKey(id));
    }

}
