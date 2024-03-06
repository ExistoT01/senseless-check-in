package org.ouc.common.pojo.entity;

import lombok.Data;

/**
 * Employee
 */
@Data
public class Employee {
    /**
     * 新建时间
     */
    private String createTime;
    /**
     * 性别
     */
    private Long gender;
    /**
     * id，ID 编号
     */
    private String id;
    /**
     * 身份证
     */
    private String idNumber;
    /**
     * 姓名，名称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 状态，启用：1，停用：0
     */
    private Long status;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 账号
     */
    private String username;
}

