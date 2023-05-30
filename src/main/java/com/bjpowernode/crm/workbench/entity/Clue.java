package com.bjpowernode.crm.workbench.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tbl_clue
 */
@TableName(value ="tbl_clue")
@Data
public class Clue implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 
     */
    @TableField(value = "full_name")
    private String fullName;

    /**
     * 数据来源于数据字典值appellation
     */
    @TableField(value = "appellation")
    private String appellation;

    /**
     * 
     */
    @TableField(value = "owner")
    private String owner;

    /**
     * 
     */
    @TableField(value = "company")
    private String company;

    /**
     * 
     */
    @TableField(value = "job")
    private String job;

    /**
     * 
     */
    @TableField(value = "email")
    private String email;

    /**
     * 
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 
     */
    @TableField(value = "website")
    private String website;

    /**
     * 
     */
    @TableField(value = "mphone")
    private String mphone;

    /**
     * 
     */
    @TableField(value = "state")
    private String state;

    /**
     * 
     */
    @TableField(value = "source")
    private String source;

    /**
     * 
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 
     */
    @TableField(value = "create_time")
    private String createTime;

    /**
     * 
     */
    @TableField(value = "edit_by")
    private String editBy;

    /**
     * 
     */
    @TableField(value = "edit_time")
    private String editTime;

    /**
     * 
     */
    @TableField(value = "description")
    private String description;

    /**
     * 
     */
    @TableField(value = "contact_summary")
    private String contactSummary;

    /**
     * 
     */
    @TableField(value = "next_contact_time")
    private String nextContactTime;

    /**
     * 
     */
    @TableField(value = "address")
    private String address;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}