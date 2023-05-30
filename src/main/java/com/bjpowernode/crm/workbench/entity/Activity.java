package com.bjpowernode.crm.workbench.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName tbl_activity
 */
@Data
public class Activity implements Serializable {
    /**
     *
     */
    private String id;

    /**
     * 用户ID
     */
    private String owner;

    /**
     * 市场活动名称
     */
    private String name;

    /**
     *
     */
    private String startDate;

    /**
     *
     */
    private String endDate;

    /**
     *
     */
    private String cost;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private String createTime;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private String editTime;

    /**
     *
     */
    private String editBy;

    @TableField(exist = false)
    private String ownerName;

    private static final long serialVersionUID = 1L;
}
