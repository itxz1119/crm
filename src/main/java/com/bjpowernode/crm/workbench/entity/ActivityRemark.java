package com.bjpowernode.crm.workbench.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tbl_activity_remark
 */
@Data
public class ActivityRemark implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String noteContent;

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

    /**
     * 0表示未修改，1表示已修改
     */
    private String editFlag;

    /**
     * 
     */
    private String activityId;

    private static final long serialVersionUID = 1L;
}