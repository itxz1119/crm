package com.bjpowernode.crm.workbench.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bjpowernode.crm.commons.utils.DateUtil;
import com.bjpowernode.crm.commons.utils.UUIDUtil;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.mapper.ActivityMapper;
import com.bjpowernode.crm.workbench.vo.ActivityEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ActivityListener extends AnalysisEventListener<ActivityEeVo> {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public void invoke(ActivityEeVo activityEeVo, AnalysisContext analysisContext) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityEeVo, activity);
        activity.setId(UUIDUtil.getUUID());
        activity.setCreateTime(DateUtil.dateToString(new Date()));
        activity.setEditTime(DateUtil.dateToString(new Date()));
        activityMapper.insert(activity);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
