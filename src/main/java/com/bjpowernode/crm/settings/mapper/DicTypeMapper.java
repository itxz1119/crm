package com.bjpowernode.crm.settings.mapper;

import com.bjpowernode.crm.settings.entity.DicType;

import java.util.List;

public interface DicTypeMapper {
    /**
     * 通过ID查询单条数据
     * @return 实例对象
     */
    DicType selectByCode(String code);

    /**
     * 查询指定行数据
     * @return 对象列表
     */
    List<DicType> select(DicType dicType);


    /**
     * 新增数据
     * @return 影响行数
     */
    int insert(DicType dicType);

    /**
     * 修改数据
     * @return 影响行数
     */
    int update(DicType dicType);

    /**
     * 通过主键删除数据
     * @return 影响行数
     */
    int deleteByCode(String code);

    /**
     * 通过主键批量删除数据
     * @return 影响行数
     */
    int deleteBatch(String[] codes);

}
