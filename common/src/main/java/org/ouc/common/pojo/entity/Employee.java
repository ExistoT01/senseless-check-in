package org.ouc.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Employee
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    /**
     * id，ID 编号
     */
    private Long id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名，名称
     */
    private String name;
    /**
     * 身份证
     */
    private String idNumber;
    /**
     * 性别，男：1，女：2，其他：3
     */
    private Integer gender;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 状态，启用：1，停用：0
     */
    private Integer status;
    /**
     * 新建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}

