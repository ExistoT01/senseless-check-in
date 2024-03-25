package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CameraPersonIdResponse implements Serializable {


    private ResponseBean Response;

    @Data
    public static class ResponseBean implements Serializable {

        /**
         * ResponseURL : HTTP请求消息携带的URL
         * CreatedID : 传输新对象的ID
         * ResponseCode : 处理系统结果
         * SubResponseCode :
         * ResponseString : 处理系统结果的解释
         * StatusCode : 处理业务结果
         * StatusString : 处理业务结果的解释
         * Data :
         */
        private String responseUrl;
        private int createdId;
        private int responseCode;
        private int subResponseCode;
        private String responseString;
        private int statusCode;
        private String statusString;
        private DataBean data;

        @Data
        public static class DataBean implements Serializable {

            //符合查询条件总数
            private int total;
            //当前序号
            private int offset;
            private PersonListBean personList;

            @Data
            public static class PersonListBean implements Serializable {

                //人员库人员个数
                private int num;
                //人员信息列表
                private List<PersonInfoListBean> personInfoList;

                @Data
                public static class PersonInfoListBean implements Serializable {

                    //人员id
                    private String personId;
                    private int lastChange;
                    private String personName;
                    private int gender;
                    private String birthday;
                    private RegionBean region;
                    private TimeTemplateBean timeTemplate;
                    private int identificationNum;
                    private int imageNum;
                    private List<IdentificationListBean> identificationList;
                    private List<ImageListBean> imageList;

                    @Data
                    public static class RegionBean implements Serializable {

                        private String nation;
                        private String province;
                        private String city;
                    }

                    @Data
                    public static class TimeTemplateBean implements Serializable {

                        private int beginTime;
                        private long endTime;
                        private int index;
                    }

                    @Data
                    public static class IdentificationListBean implements Serializable {


                        private int type;
                        private String number;
                    }

                    @Data
                    public static class ImageListBean implements Serializable {

                        private int faceId;
                        private String name;
                        private int size;
                        private String data;
                    }
                }
            }
        }
    }
}