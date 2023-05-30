package com.bjpowernode.crm.workbench.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjpowernode.crm.workbench.entity.Activity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface ActivityService extends IService<Activity> {

    int deleteByPrimaryKey(String id);

    int insert(Activity record);

    Activity selectByPrimaryKey(String id);

    Map<String, Object> select(Integer pageNumber, Integer pageSize, Activity activity);

    int updateByPrimaryKeySelective(Activity record);

    void exportData(HttpServletResponse response);

    void importData(MultipartFile file);
}
