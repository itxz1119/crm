package com.bjpowernode.crm.workbench.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ActivityEeVo {

    @ExcelProperty(value = "市场活动",index = 0)
    private String name;

    @ExcelProperty(value = "负责人",index = 1)
    private String ownerName;

    @ExcelProperty(value = "开始时间", index = 2)
    private String startDate;

    @ExcelProperty(value = "结束时间", index = 3)
    private String endDate;

}
