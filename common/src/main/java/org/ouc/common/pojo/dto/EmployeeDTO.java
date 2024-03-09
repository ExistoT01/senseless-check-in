package org.ouc.common.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    private Long id; //id，ID 编号
    private String username; //账号
    private String name; //姓名，名称
    private Integer gender; //性别
    private String idNumber; //身份证
    private String phoneNumber; //手机号码

}
