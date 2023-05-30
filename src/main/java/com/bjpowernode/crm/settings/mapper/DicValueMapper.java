package com.bjpowernode.crm.settings.mapper;

import com.bjpowernode.crm.settings.entity.DicValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DicValueMapper {
    /**
     * 通过ID查询单条数据
     * @return 实例对象
     */
    DicValue selectByCodeAndValue(@Param("typeCode") String typeCode, @Param("value") String value);

    DicValue selectById(String id);
    /**
     * 查询指定行数据
     * @return 对象列表
     */
    List<DicValue> select(DicValue dicValue);


    /**
     * 新增数据
     * @return 影响行数
     */
    int insert(DicValue dicValue);

    /**
     * 修改数据
     * @return 影响行数
     */
    int update(DicValue dicValue);

    /**
     * 通过主键删除数据
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 通过主键批量删除数据
     * @return 影响行数
     */
    int deleteBatch(String[] ids);

    List<DicValue> selectByCode(String typeCode);
}
