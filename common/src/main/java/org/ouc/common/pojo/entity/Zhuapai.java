package org.ouc.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zhuapai {
    private ZhuapaiChild[] children;
    private String key;
    /**
     * 摄像头名
     */
    private String title;
}
