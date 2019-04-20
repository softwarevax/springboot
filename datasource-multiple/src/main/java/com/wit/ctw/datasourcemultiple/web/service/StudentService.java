package com.wit.ctw.datasourcemultiple.web.service;

import com.wit.ctw.datasourcemultiple.web.entity.school.Student;

import java.util.List;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.service
 * @Description:
 * @date 2019/4/15 23:57
 */
public interface StudentService {

    List<Student> students();
}
