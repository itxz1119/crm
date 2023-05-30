package com.bjpowernode.crm.workbench.controller;

import com.bjpowernode.crm.commons.utils.DateUtil;
import com.bjpowernode.crm.commons.utils.Result;
import com.bjpowernode.crm.commons.utils.UUIDUtil;
import com.bjpowernode.crm.settings.entity.User;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Api(tags = "市场活动")
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;


    @ApiOperation("根据id获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable String id) {
        return Result.ok(activityService.selectByPrimaryKey(id));
    }

    @ApiOperation("查询全部")
    @GetMapping("page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNumber,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       Activity activity) {

        return Result.ok(activityService.select(pageNumber, pageSize, activity));
    }

    @ApiOperation("添加")
    @PostMapping("save")
    public Result save(@RequestBody Activity activity, HttpSession session) {
        //        create_time, create_by
//                , edit_time, edit_by
        User loginUser = (User) session.getAttribute("loginUser");
        activity.setId(UUIDUtil.getUUID());
        activity.setCreateBy(loginUser.getLoginAct());
        activity.setEditBy(loginUser.getLoginAct());
        activity.setCreateTime(DateUtil.dateToString(new Date()));
        activity.setEditTime(DateUtil.dateToString(new Date()));
        return Result.ok(activityService.insert(activity));
    }

    @ApiOperation("修改")
    @PutMapping("edit")
    public Result edit(@RequestBody Activity activity, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        activity.setEditBy(loginUser.getLoginAct());
        activity.setEditTime(DateUtil.dateToString(new Date()));
        return Result.ok(activityService.updateByPrimaryKeySelective(activity));
    }

    @ApiOperation("删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id) {
        return Result.ok(activityService.deleteByPrimaryKey(id));
    }

    @ApiOperation("列表导出")
    @GetMapping("exportData")
    public void exportData(HttpServletResponse response) {
        activityService.exportData(response);
    }

    @ApiOperation("列表导入")
    @PostMapping("importData")
    public Result importData(MultipartFile file){
        activityService.importData(file);
        return Result.ok(null).message("导入成功");
    }
}
