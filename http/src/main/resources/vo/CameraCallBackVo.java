package org.ouc.http.src.main.resources.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 摄像头回调信息
 */

@Data
public class CameraCallBackVo implements Serializable {


    private String DeviceCode;
    private PersonEventInfoBean PersonEventInfo;

    @Data
    public static class PersonEventInfoBean implements Serializable {

        @SerializedName("ID")
        private int id;
        //抓拍时间戳 秒级
        private double Timestamp;
        // 摄像头名称
        private String cameraTitle;
        // 通知类型
        private int NotificationType;
        // 人脸信息数量
        private int FaceInfoNum;
        private List<FaceInfoListBean> FaceInfoList;

        @Data
        public static class FaceInfoListBean implements Serializable {

            private int RecordID;
            // 0：人脸抓拍
            // 1：比对成功告警
            // 2: 比对失败告警
            private int Type;
            private long PassingTime;
            private String ChannelName;
            private int ChannelID;
            private CompareInfoBean CompareInfo;

            @Data
            public static class CompareInfoBean implements Serializable {

                //相似度
                private int Similarity;
                private PersonInfoBean PersonInfo;
                private SnapshotImageBean SnapshotImage;
                private int FeatureNum;
                private List<FeatureListBean> FeatureList;

                @Data
                public static class PersonInfoBean implements Serializable {

                    // 人员ID
                    private int PersonID;
                    // 最后更改时间
                    private long LastChange;
                    //员工姓名
                    private String PersonName;
                    // 性别
                    private int Gender;
                    // 生日
                    private String Birthday;
                    // 地区
                    private org.jeecg.modules.demo.cameramanage.vo.CameraCallBackVo.PersonEventInfoBean.FaceInfoListBean.CompareInfoBean.PersonInfoBean.RegionBean Region;
                    // 证件信息个数
                    // PTS范围:[0, 6]
                    private int IdentificationNum;
                    private int BelongLibNum;
                    // 人脸图片个数
                    private int ImageNum;
                    private List<IdentificationListBean> IdentificationList;
                    private List<BelongLibIDListBean> BelongLibIDList;
                    private List<ImageListBean> ImageList;

                    @Data
                    // 成员地区信息
                    public static class RegionBean implements Serializable {


                        private String Nation;
                        private String Province;
                        private String City;
                    }

                    @Data
                    // 证件信息个数
                    public static class IdentificationListBean implements Serializable {

                        // 证件类型 0:身份证 1:IC卡 2:护照 3:行驶证 99:其他仅速通门支持IC卡。
                        private int Type;
                        // 证件号，
                        // 范围:[1, 20]
                        private String Number;
                    }

                    @Data
                    // 部门信息
                    public static class BelongLibIDListBean implements Serializable {

                        private long libID;
                    }

                    @Data
                    // 人员图片信息
                    public static class ImageListBean implements Serializable {

                        private int FaceID;
                        private String Name;
                        private int Size;
                        // 图片数据，需要是Base64编码格式的jpg图片
                        private String Data;
                    }
                }

                @Data
                // 抓拍记录
                public static class SnapshotImageBean implements Serializable {

                    private BigImageBean BigImage;
                    private SmallImageBean SmallImage;
                    private AreaBean Area;

                    @Data
                    public static class BigImageBean implements Serializable {

                        private String Name;
                        private int Size;
                        private String Data;
                    }

                    @Data
                    public static class SmallImageBean implements Serializable {

                        private String Name;
                        private int Size;
                        private String Data;
                    }

                    @Data
                    public static class AreaBean implements Serializable {

                        private int Left;
                        private int Top;
                        private int Right;
                        private int Bottom;
                    }
                }

                @Data
                public static class FeatureListBean implements Serializable {

                    private String FeatureVersion;
                    private String Feature;
                    private String FeatureManufacturer;
                }
            }
        }
    }
}
