package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 摄像头订阅返回参数
 */
@Data
public class CameraSubscribeResponse implements Serializable {

    private ResponseBean response;

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
         * Data : {"ID":65280,"Reference":"203.5.92.17:80/Subscription/Subscribers/65280","CurrentTime":1322668959,"TerminationTime":1322669019,"SupportType":63}
         */

        private String responseUrl;
        private String createdId;
        private int responseCode;
        private int subResponseCode;
        private String responseString;
        private int statusCode;
        private String statusString;
        private DataBean data;

        @Data
        public static class DataBean implements Serializable {
            /**
             * ID : 识别订阅Id
             * Reference : 订阅者描述信息url
             * CurrentTime : 开始时间
             * TerminationTime : 终止时间
             * SupportType : 订阅类型
             */

            @SerializedName("ID")
            private int id;
            private String reference;
            private int currentTime;
            private int terminationTime;
            private int supportType;
        }
    }
}
