package org.ouc.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {

    /**
     * 迟到数
     */
    private String lateArrivals;
    /**
     * 员工id
     */
    private String employeeId;
    /**
     * 加班数
     */
    private String overtime;
    /**
     * 员工名称
     */
    private String name;
    /**
     * 缺勤数
     */
    private String absences;
    /**
     * 排名
     */
    private String rank;
    /**
     * 早到数
     */
    private String earlyArrivals;
    /**
     * 早退数
     */
    private String earlyLeaves;
}


