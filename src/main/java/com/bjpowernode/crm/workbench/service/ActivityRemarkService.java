package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.entity.ActivityRemark;

import java.util.List;

public interface ActivityRemarkService {

    int deleteByPrimaryKey(String id);

    int insert(ActivityRemark record);

    ActivityRemark selectByPrimaryKey(String id);

    List<ActivityRemark> select(ActivityRemark activityRemark);

    int updateByPrimaryKeySelective(ActivityRemark record);
}
