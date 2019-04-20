package com.wit.ctw.datasourcemultiple.web.controller;

import com.alibaba.fastjson.JSON;
import com.wit.ctw.datasourcemultiple.web.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.controller
 * @Description: staff接口
 * @date 2019/4/16 0:15
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/staffs")
    public String staff() {
        return JSON.toJSONString(staffService.stadffs());
    }
}
