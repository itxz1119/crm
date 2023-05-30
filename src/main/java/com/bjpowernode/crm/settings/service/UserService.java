package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User selectById(String id);

    Map<String, Object> select(Integer pageNumber,Integer pageSize,User user);

    List<User> list(User user);
    /**
     * 根据登录账号查询
     * @param loginAct 登录账号
     * @return 登录用户对象
     */
    User selectByLoginAct(String loginAct);

    Boolean insert(User user);

    Boolean update(User user);

    Boolean deleteById(String id);

    Boolean deleteBatch(String[] ids);

    User login(String loginAct, String pwd);

}
