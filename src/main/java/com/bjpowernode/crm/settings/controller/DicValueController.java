package com.bjpowernode.crm.settings.controller;

import com.bjpowernode.crm.commons.utils.Result;
import com.bjpowernode.crm.settings.entity.DicValue;
import com.bjpowernode.crm.settings.service.DicValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "字典值")
@RestController
@RequestMapping("/dicValue")
public class DicValueController {

    @Autowired
    private DicValueService dicValueService;


    @ApiOperation("分页条件查询")
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNumber,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       DicValue dicValue) {
        Map<String, Object> map = dicValueService.select(pageNumber, pageSize, dicValue);
        return Result.ok(map);
    }

    @ApiOperation("添加")
    @PostMapping("/save")
    public Result save(@RequestBody DicValue dicValue) {
        dicValueService.insert(dicValue);
        return Result.ok(null);
    }

    @ApiOperation("根据id查询")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id) {
        DicValue dicValue = dicValueService.selectById(id);
        return Result.ok(dicValue);
    }

    @ApiOperation("修改")
    @PutMapping("/edit")
    public Result update(@RequestBody DicValue dicValue) {
        dicValueService.update(dicValue);
        return Result.ok(null);
    }

    @ApiOperation("单个删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable String id) {
        dicValueService.deleteById(id);
        return Result.ok(null);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/removeBatch")
    public Result removeBatch(String[] ids) {
        dicValueService.deleteBatch(ids);
        return Result.ok(null);
    }

}
