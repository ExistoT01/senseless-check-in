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

        private int NotificationType;
        private int FaceInfoNum;
        private List<FaceInfoListBean> FaceInfoList;

        @Data
        public static class FaceInfoListBean implements Serializable {

            private int RecordID;
            //0：人脸抓拍  1：比对成功告警  2: 比对失败告警
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

                    private int PersonID;
                    private long LastChange;
                    //员工姓名
                    private String PersonName;
                    //性别
                    private int Gender;
                    private String Birthday;
                    private RegionBean Region;
                    private int IdentificationNum;
                    private int BelongLibNum;
                    private int ImageNum;
                    private List<IdentificationListBean> IdentificationList;
                    private List<BelongLibIDListBean> BelongLibIDList;
                    private List<ImageListBean> ImageList;

                    @Data
                    public static class RegionBean implements Serializable {

                        //钉钉id
                        private String Nation;
                        //部门id
                        private String Province;
                        private String City;
                    }

                    @Data
                    public static class IdentificationListBean implements Serializable {

                        private int Type;
                        private String Number;
                    }

                    @Data
                    public static class BelongLibIDListBean implements Serializable {

                        private long libID;
                    }

                    @Data
                    public static class ImageListBean implements Serializable {

                        private int FaceID;
                        private String Name;
                        private int Size;
                        private String Data;
                    }
                }

                @Data
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
