package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.entity.DicValue;

import java.util.List;
import java.util.Map;

public interface DicValueService {

    Map<String, Object> select(Integer pageNumber, Integer pageSize, DicValue dicValue);


    Boolean insert(DicValue dicValue);


    int update(DicValue dicValue);


    int deleteById(String id);


    int deleteBatch(String[] ids);

    DicValue selectById(String id);

    DicValue selectByCodeAndValue(String typeCode, String value);

    List<DicValue> selectByCode(String typeCode);
}
