package com.wit.ctw.datasourcemultiple.web.entity.school;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.repository.school
 * @Description: 学生类
 * @date 2019/4/15 23:18
 */
@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    private String stuId;

    private String stuName;

    private int stuSex;

    private int stuAge;

    private String stuHabit;
}
