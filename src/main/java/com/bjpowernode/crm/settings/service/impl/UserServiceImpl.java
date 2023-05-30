package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.commons.utils.MD5Util;
import com.bjpowernode.crm.settings.entity.DicValue;
import com.bjpowernode.crm.settings.entity.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.settings.service.DicValueService;
import com.bjpowernode.crm.settings.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DicValueService dicValueService;

    @Override
    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public Map<String, Object> select(Integer pageNumber,Integer pageSize,User user) {
        PageHelper.startPage(pageNumber, pageSize);
        List<User> userList = userMapper.select(user);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        List<DicValue> dicValueList = dicValueService.selectByCode("lockState");
        List<User> infoList = pageInfo.getList();
        for (User user1 : infoList) {
            DicValue dicValue = dicValueService.selectByCodeAndValue("lockState", user1.getLockState());
            user1.setLockState(dicValue.getText());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("list", infoList);
        map.put("total",pageInfo.getTotal());
        map.put("dicValueList",dicValueList);
        return map;
    }

    @Override
    public User selectByLoginAct(String loginAct) {
        return userMapper.selectByLoginAct(loginAct);
    }

    @Override
    public Boolean insert(User user) {
        user.setLoginPwd(MD5Util.getMD5(user.getLoginPwd()));
        return userMapper.insert(user) > 0;
    }
    @Override
    public Boolean update(User user) {
        return userMapper.update(user) > 0;
    }

    @Override
    public Boolean deleteById(String id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean deleteBatch(String[] ids) {
        return userMapper.deleteBatch(ids) > 0;
    }

    @Override
    public User login(String loginAct, String pwd) {
        User user = userMapper.selectByLoginActAndPwd(loginAct,MD5Util.getMD5(pwd));
        return user;
    }

    @Override
    public List<User> list(User user) {
        return userMapper.select(user);
    }
}
