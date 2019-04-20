package com.wit.ctw.datasourcemultiple.web.entity.social;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ctw
 * @Project： datasource-multiple
 * @Package: com.wit.ctw.datasourcemultiple.web.entity.social
 * @Description: 员工实体类
 * @date 2019/4/15 23:28
 */
@Data
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    private String staffId;

    private String staffName;

    private String staffPosition;

    private String staffSuffer;

    private String staffCompany;
}
