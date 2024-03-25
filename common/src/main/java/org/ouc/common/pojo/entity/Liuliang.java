package org.ouc.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Response.java

public class Liuliang {
    private Child[] children;
    /**
     * 总人流量
     */
    private String total;

    public Liuliang(String number, Child[] children) {
        this.total = number;
        this.children = children;
    }

    public Child[] getChildren() { return children; }
    public void setChildren(Child[] value) { this.children = value; }

    public String getTotal() { return total; }
    public void setTotal(String value) { this.total = value; }
}

