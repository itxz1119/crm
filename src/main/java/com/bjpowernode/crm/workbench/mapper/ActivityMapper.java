package com.bjpowernode.crm.workbench.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjpowernode.crm.workbench.entity.Activity;

import java.util.List;

/**
* @author 85766
* @description 针对表【tbl_activity】的数据库操作Mapper
* @createDate 2022-09-17 11:53:48
* @Entity com.bjpowernode.crm.workbench.entity.Activity
*/
public interface ActivityMapper extends BaseMapper<Activity> {

    int deleteByPrimaryKey(String id);

    int insert(Activity record);

    Activity selectByPrimaryKey(String id);

    List<Activity> select(Activity activity);

    int updateByPrimaryKeySelective(Activity record);


}
