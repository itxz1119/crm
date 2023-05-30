package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.workbench.entity.ActivityRemark;
import com.bjpowernode.crm.workbench.mapper.ActivityRemarkMapper;
import com.bjpowernode.crm.workbench.service.ActivityRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityRemarkServiceImpl implements ActivityRemarkService {
    @Autowired
    private ActivityRemarkMapper activityRemarkMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return activityRemarkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ActivityRemark record) {
        return activityRemarkMapper.insert(record);
    }

    @Override
    public ActivityRemark selectByPrimaryKey(String id) {
        return activityRemarkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ActivityRemark> select(ActivityRemark activityRemark) {
        return activityRemarkMapper.select(activityRemark);
    }

    @Override
    public int updateByPrimaryKeySelective(ActivityRemark record) {
        return activityRemarkMapper.updateByPrimaryKeySelective(record);
    }
}
