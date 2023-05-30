package com.bjpowernode.crm.workbench.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjpowernode.crm.commons.exception.CrmException;
import com.bjpowernode.crm.settings.entity.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.workbench.listener.ActivityListener;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.mapper.ActivityMapper;
import com.bjpowernode.crm.workbench.service.ActivityService;
import com.bjpowernode.crm.workbench.vo.ActivityEeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityListener activityListener;

    @Override
    public int deleteByPrimaryKey(String id) {
        return activityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Activity record) {
        return activityMapper.insert(record);
    }

    @Override
    public Activity selectByPrimaryKey(String id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> select(Integer pageNumber, Integer pageSize, Activity activity) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Activity> activityList = activityMapper.select(activity);
        PageInfo<Activity> pageInfo = new PageInfo<>(activityList);
        List<User> userList = userService.list(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        map.put("userList", userList);
        return map;
    }

    @Override
    public int updateByPrimaryKeySelective(Activity record) {
        return activityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void exportData(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("市场活动", "utf-8");
            response.setHeader("Content-disposition", "attachment;filename="+ fileName + ".xlsx");

            List<Activity> activityList = activityMapper.select(null);
            List<ActivityEeVo> activityEeVoList = new ArrayList<>();
            for (Activity activity : activityList) {
                ActivityEeVo activityEeVo = new ActivityEeVo();
                BeanUtils.copyProperties(activity, activityEeVo);
                activityEeVoList.add(activityEeVo);
            }

            EasyExcel.write(response.getOutputStream(), ActivityEeVo.class)
                    .sheet("市场活动")
                    .doWrite(activityEeVoList);
        } catch (Exception e) {
            throw new CrmException(501,"导出失败");
        }
    }

    @Override
    public void importData(MultipartFile file) {
        /*try {
            EasyExcel.read(file.getInputStream(), SubjectEeVo.class, subjectListener)
                    .sheet().doRead();
        }catch (Exception e){
            throw new GgktException(20001,"导入失败!");
        }*/
        try {
            EasyExcel.read(file.getInputStream(), ActivityEeVo.class, activityListener)
                    .sheet().doRead();
        }catch (Exception e){
            throw new CrmException(501,"导入失败");
        }

    }
}
