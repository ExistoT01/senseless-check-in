package org.ouc.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhuapaiChild {
    /**
     * 图片url
     */
    private String imgUrl;
    private String key;
    /**
     * 照片名
     */
    private String title;
}
