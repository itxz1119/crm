package com.bjpowernode.crm.commons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/settings/index")
    public String settingsIndex() {
        return "settings/index";
    }

    @RequestMapping("/qx/index")
    public String qxIndex() {
        return "settings/qx/index";
    }

    @RequestMapping("/qx/user/index")
    public String userIndex() {
        return "settings/qx/user/index";
    }

    @RequestMapping("/dictionary/index")
    public String dictionaryIndex() {
        return "settings/dictionary/index";
    }

    @RequestMapping("/dictionary/type/index")
    public String typeIndex() {
        return "settings/dictionary/type/index";
    }

    @RequestMapping("/dictionary/value/index")
    public String valueIndex() {
        return "settings/dictionary/value/index";
    }

    @RequestMapping("workbench/index")
    public String workbenchIndex() {
        return "workbench/index";
    }

    @RequestMapping("main/index")
    public String mainIndex() {
        return "workbench/main/index";
    }

    @RequestMapping("activity/index")
    public String activityIndex() {
        return "workbench/activity/index";
    }

    @RequestMapping("activity/detail")
    public String activityDetail() {
        return "workbench/activity/detail";
    }


    /*
    * 线索
    * */
    @RequestMapping("clue/index")
    public String clueIndex() {
        return "workbench/clue/index";
    }

}
