package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.entity.DicType;

import java.util.Map;

public interface DicTypeService {

    DicType selectByCode(String code);

    Map<String, Object> select(Integer pageNumber, Integer pageSize, DicType dicType);



    int insert(DicType dicType);


    int update(DicType dicType);


    int deleteByCode(String code);


    int deleteBatch(String[] codes);
}
