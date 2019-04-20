package com.wit.ctw.datasourcemultiple.web.service.impl;

import com.wit.ctw.datasourcemultiple.web.entity.school.Student;
import com.wit.ctw.datasourcemultiple.web.repository.school.StudentDao;
import com.wit.ctw.datasourcemultiple.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.service.impl
 * @Description: 学生实体
 * @date 2019/4/15 23:57
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> students() {
        return studentDao.findAll();
    }
}
