package com.bjpowernode.crm.settings.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjpowernode.crm.settings.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    User selectById(String id);

    /**
     * 查询指定行数据
     * @param user 查询条件
     * @return 对象列表
     */
    List<User> select(User user);

    /**
     * 根据登录账号查询
     * @param loginAct 登录账号
     * @return 登录用户对象
     */
    User selectByLoginAct(String loginAct);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 影响行数
     */
    int deleteBatch(String[] ids);

    User selectByLoginActAndPwd(@Param("loginAct") String loginAct, @Param("pwd") String pwd);
}
