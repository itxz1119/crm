package com.bjpowernode.crm.settings.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-09-13 10:44:43
 */
@ApiModel("用户")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 575358293343755701L;
    /**
     * uuid
     */
    @ApiModelProperty("用户id")
    @TableId
    private String id;
    @ApiModelProperty("用户账号")

    @TableField("login_act")
    private String loginAct;

    private String name;
    /**
     * 密码不能采用明文存储，采用密文，MD5加密之后的数据
     */
    private String loginPwd;

    private String email;
    /**
     * 失效时间为空的时候表示永不失效，失效时间为2018-10-10 10:10:10，则表示在该时间之前该账户可用。
     */
    @ApiModelProperty("失效时间")
    private String expireTime;
    /**
     * 锁定状态为空时表示启用，为0时表示锁定，为1时表示启用。
     */
    private String lockState;

    private String deptNo;
    /**
     * 允许访问的IP为空时表示IP地址永不受限，允许访问的IP可以是一个，也可以是多个，当多个IP地址的时候，采用半角逗号分隔。允许IP是192.168.100.2，表示该用户只能在IP地址为192.168.100.2的机器上使用。
     */
    private String allowIps;

    private String createTime;
    /**
     * 用户ID
     */
    private String createBy;

    private String editTime;
    /**
     * 用户ID
     */
    private String editBy;

    /**
     * 失效的开始时间
     */
    @TableField(exist = false)
    private String startTime;
    /**
     * 失效的结束时间
     */
    @TableField(exist = false)
    private String endTime;


}

