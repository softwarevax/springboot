package com.wit.ctw.datasourcemultiple.web.service.impl;

import com.wit.ctw.datasourcemultiple.web.entity.social.Staff;
import com.wit.ctw.datasourcemultiple.web.repository.social.StaffDao;
import com.wit.ctw.datasourcemultiple.web.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.service.impl
 * @Description: 员工接口实现
 * @date 2019/4/16 0:18
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffDao staffDao;

    @Override
    public List<Staff> stadffs() {
        return staffDao.findAll();
    }
}
