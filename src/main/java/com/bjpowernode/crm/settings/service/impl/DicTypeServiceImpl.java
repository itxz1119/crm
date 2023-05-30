package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.settings.entity.DicType;
import com.bjpowernode.crm.settings.mapper.DicTypeMapper;
import com.bjpowernode.crm.settings.service.DicTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DicTypeServiceImpl implements DicTypeService {
    @Autowired
    private DicTypeMapper dicTypeMapper;

    @Override
    public DicType selectByCode(String code) {
        return dicTypeMapper.selectByCode(code);
    }

    @Override
    public Map<String, Object> select(Integer pageNumber, Integer pageSize, DicType dicType) {
        PageHelper.startPage(pageNumber, pageSize);
        List<DicType> dicTypeList = dicTypeMapper.select(dicType);
        PageInfo<DicType> pageInfo = new PageInfo<>(dicTypeList);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", dicTypeList);
        map.put("total", pageInfo.getTotal());
        return map;
    }

    @Override
    public int insert(DicType dicType) {
        return dicTypeMapper.insert(dicType);
    }

    @Override
    public int update(DicType dicType) {
        return dicTypeMapper.update(dicType);
    }

    @Override
    public int deleteByCode(String code) {
        return dicTypeMapper.deleteByCode(code);
    }

    @Override
    public int deleteBatch(String[] codes) {
        return dicTypeMapper.deleteBatch(codes);
    }
}


