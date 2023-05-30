package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.commons.exception.CrmException;
import com.bjpowernode.crm.commons.utils.UUIDUtil;
import com.bjpowernode.crm.settings.entity.DicType;
import com.bjpowernode.crm.settings.entity.DicValue;
import com.bjpowernode.crm.settings.mapper.DicTypeMapper;
import com.bjpowernode.crm.settings.mapper.DicValueMapper;
import com.bjpowernode.crm.settings.service.DicValueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DicValueServiceImpl implements DicValueService {
    @Autowired
    private DicValueMapper dicValueMapper;

    @Autowired
    private DicTypeMapper dicTypeMapper;


    @Override
    public Map<String, Object> select(Integer pageNumber, Integer pageSize, DicValue dicValue) {
        PageHelper.startPage(pageNumber, pageSize);
        List<DicValue> dicValueList = dicValueMapper.select(dicValue);
        PageInfo<DicValue> pageInfo = new PageInfo<>(dicValueList);
        List<DicType> dicTypeList = dicTypeMapper.select(null);

        HashMap<String, Object> map = new HashMap<>();
        map.put("list", pageInfo.getList());
        map.put("dicTypeList", dicTypeList);
        map.put("total", pageInfo.getTotal());
        return map;
    }

    @Override
    public Boolean insert(DicValue dicValue) {
        DicValue value = dicValueMapper.selectByCodeAndValue(dicValue.getTypeCode(), dicValue.getValue());
        if (value != null){
            throw new CrmException(501,"该字典值已经存在!");
        }
        dicValue.setId(UUIDUtil.getUUID());
        return dicValueMapper.insert(dicValue) > 0;
    }

    @Override
    public int update(DicValue dicValue) {
        return dicValueMapper.update(dicValue);
    }

    @Override
    public int deleteById(String id) {
        return dicValueMapper.deleteById(id);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return dicValueMapper.deleteBatch(ids);
    }

    @Override
    public DicValue selectById(String id) {
        DicValue dicValue = dicValueMapper.selectById(id);
        return dicValue;
    }

    @Override
    public DicValue selectByCodeAndValue(String typeCode, String value) {
        DicValue dicValue = dicValueMapper.selectByCodeAndValue(typeCode, value);
        return dicValue;
    }

    @Override
    public List<DicValue> selectByCode(String typeCode) {
        return dicValueMapper.selectByCode(typeCode);
    }
}


