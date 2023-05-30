package com.bjpowernode.crm.workbench.mapper;

import com.bjpowernode.crm.workbench.entity.ActivityRemark;

import java.util.List;

/**
* @author 85766
* @description 针对表【tbl_activity_remark】的数据库操作Mapper
* @createDate 2022-09-17 17:19:05
* @Entity com.bjpowernode.crm.workbench.entity.ActivityRemark
*/
public interface ActivityRemarkMapper {

    int deleteByPrimaryKey(String id);

    int insert(ActivityRemark record);

    ActivityRemark selectByPrimaryKey(String id);

    List<ActivityRemark> select(ActivityRemark activityRemark);

    int updateByPrimaryKeySelective(ActivityRemark record);


}
