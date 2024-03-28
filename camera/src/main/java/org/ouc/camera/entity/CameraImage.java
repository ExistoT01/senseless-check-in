package org.ouc.camera.src.main.java.org.ouc.camera.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CameraImage implements Serializable{
    private String title;   // 摄像头名称
    private String key;
    private ImageListBean children;    // 抓拍数据集

    @Data
    public static class ImageListBean implements Serializable{
        private String title;   // 照片名
        private String key;
        private String imgUrl;  // 图片url

        public void setTitle(String title) {
            this.title = title;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
