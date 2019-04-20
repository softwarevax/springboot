package com.wit.ctw.datasourcemultiple.web.repository.school;

import com.wit.ctw.datasourcemultiple.web.entity.school.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.repository.school
 * @Description: 学生数据访问层dao
 * @date 2019/4/15 23:24
 */
@Repository
public interface StudentDao extends JpaRepository<Student, String> {
}
