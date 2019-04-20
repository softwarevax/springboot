package com.wit.ctw.datasourcemultiple.web.controller;

import com.alibaba.fastjson.JSON;
import com.wit.ctw.datasourcemultiple.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.controller
 * @Description: 接口
 * @date 2019/4/15 23:55
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String students() {
        return JSON.toJSONString(studentService.students());
    }
}
