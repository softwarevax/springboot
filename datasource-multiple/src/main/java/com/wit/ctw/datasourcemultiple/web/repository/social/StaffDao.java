package com.wit.ctw.datasourcemultiple.web.repository.social;

import com.wit.ctw.datasourcemultiple.web.entity.social.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.repository.social
 * @Description: 员工数据库访问层dao
 * @date 2019/4/15 23:31
 */
@Repository
public interface StaffDao extends JpaRepository<Staff, String> {
}
