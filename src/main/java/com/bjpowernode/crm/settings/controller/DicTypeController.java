package com.bjpowernode.crm.settings.controller;

import com.bjpowernode.crm.commons.utils.Result;
import com.bjpowernode.crm.settings.entity.DicType;
import com.bjpowernode.crm.settings.service.DicTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "数据字典类型")
@RestController
@RequestMapping("/dicType")
public class DicTypeController {

    @Autowired
    private DicTypeService dicTypeService;

    @ApiOperation("根据code查询")
    @GetMapping("get/{code}")
    public Result get(@PathVariable String code){
        DicType dicType = dicTypeService.selectByCode(code);
        return Result.ok(dicType);
    }

    @ApiOperation("分页条件查询")
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNumber,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       DicType dicType){
        Map<String, Object> map = dicTypeService.select(pageNumber, pageSize, dicType);
        return Result.ok(map);
    }

    @ApiOperation("添加")
    @PostMapping("/save")
    public Result save(@RequestBody DicType dicType){
        System.out.println("==================save==================");
        DicType type = dicTypeService.selectByCode(dicType.getCode());
        if (type != null){
            return Result.fail(null).message("该字典类型已存在");
        }
        dicTypeService.insert(dicType);
        return Result.ok(null);
    }

    @ApiOperation("修改")
    @PutMapping("/update")
    public Result update(@RequestBody DicType dicType){
        dicTypeService.update(dicType);
        return Result.ok(null);
    }

    @ApiOperation("单个删除")
    @DeleteMapping("/remove/{code}")
    public Result remove(@PathVariable String code){
        dicTypeService.deleteByCode(code);
        return Result.ok(null);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/removeBatch")
    public Result removeBatch(String[] codes){
        dicTypeService.deleteBatch(codes);
        return Result.ok(null);
    }

}
