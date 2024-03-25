package org.ouc.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Liuliang {
    private String name;
    private String idNumber;
    private String purp; // 打卡目的
    private String gender;
    private String sec; // 部门

    // 构造方法、getter和setter省略...
}