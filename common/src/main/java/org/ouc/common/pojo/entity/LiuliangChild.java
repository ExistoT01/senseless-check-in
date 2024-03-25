package org.ouc.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiuliangChild {
    /**
     * 性别
     */
    private String gender;
    /**
     * 员工id
     */
    private String idNumber;
    /**
     * 员工名称
     */
    private String name;
    /**
     * 打卡目的，例如：进入，出
     */
    private String purp;
    /**
     * 部门
     */
    private String sec;

    public String getGender() { return gender; }
    public void setGender(String value) { this.gender = value; }

    public String getidNumber() { return idNumber; }
    public void setidNumber(String value) { this.idNumber = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getPurp() { return purp; }
    public void setPurp(String value) { this.purp = value; }

    public String getsec() { return sec; }
    public void setsec(String value) { this.sec = value; }
}