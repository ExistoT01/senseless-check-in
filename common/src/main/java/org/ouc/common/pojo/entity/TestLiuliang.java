package org.ouc.common.pojo.entity;

// Response.java

public class TestLiuliang {
    private LiuliangChild[] liuliangChildren;
    /**
     * 总人流量
     */
    private String total;

    public TestLiuliang(String number, LiuliangChild[] liuliangChildren) {
        this.total = number;
        this.liuliangChildren = liuliangChildren;
    }

    public LiuliangChild[] getChildren() { return liuliangChildren; }
    public void setChildren(LiuliangChild[] value) { this.liuliangChildren = value; }

    public String getTotal() { return total; }
    public void setTotal(String value) { this.total = value; }
}

