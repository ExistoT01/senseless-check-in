package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class CameraFaceDatabaseResponse implements Serializable {

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
        private String responseURL;
        private int createdID;
        private int responseCode;
        private int subResponseCode;
        private String responseString;
        private int statusCode;
        private String statusString;
        private DataBean data;

        @Data
        public static class DataBean implements Serializable {

            private int num;
            private List<LibListBean> libList;

            @Data
            public static class LibListBean implements Serializable {

                @SerializedName("ID")
                //库id
                private long id;
                private int type;
                //人员信息总数
                private int personNum;
                //人脸照片总数
                private int faceNum;
                //库中人员成员的总数
                private int memberNum;
                private int lastChange;
                //库名称
                private String name;
                private String belongIndex;
            }
        }
    }
}
