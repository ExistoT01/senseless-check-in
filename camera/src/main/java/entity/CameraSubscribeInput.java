package entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class CameraSubscribeInput implements Serializable {

    /**
     * AddressType : 0 默认ipv4
     * IPAddress : IP地址
     * Port : 端口地址
     * Duration : 订阅时间，单位秒 范围:[30, 3600]
     * Type : 订阅类型
     * SubscribePersonCondition : {"LibIDNum":65535,"LibIDList":[{"LibID":0}]}
     */

    @JSONField(name = "AddressType")
    private long addressType = 0;
    @JSONField(name = "IPAddress")
    private String ipAddress;
    @JSONField(name = "Port")
    private long port;
    @JSONField(name = "Duration")
    private long duration = 3600;
    @JSONField(name = "Type")
    private long type = 16;
    @JSONField(name = "SubscribePersonCondition")
    private SubscribePersonConditionBean subscribePersonCondition;
    /**
     * Test : {"id":4,"userid":"用户Id","object":{"prop1":1,"prop2":"test"},"created_at":"2012-06-02 23:33:90","user_list":[{"id":"2","name":"测试1"},{"id":"6","name":"测试2"}]}
     * Test2 : {"Prop2":"值1"}
     */

    private TestBean Test;
    private Test2Bean Test2;

    public CameraSubscribeInput(){
        setSubscribePersonCondition(new SubscribePersonConditionBean());
    }

    @Data
    public static class SubscribePersonConditionBean implements Serializable {
        /**
         * LibIDNum : 订阅的库ID数目 默认65535订阅所有库
         */

        @JSONField(name = "LibIDNum")
        private long libIdNum = 65535;
        @JSONField(name = "LibIDList")
        private List<LibIDListBean> libIdList;

        @Data
        public static class LibIDListBean implements Serializable {
            /**
             * LibID : 人脸库id
             */

            @JSONField(name = "LibID")
            private long libId;
        }
    }

    @Data
    public static class TestBean implements Serializable {
        /**
         * id : 4
         * userid : 用户Id
         * object : {"prop1":1,"prop2":"test"}
         * created_at : 2012-06-02 23:33:90
         * user_list : [{"id":"2","name":"测试1"},{"id":"6","name":"测试2"}]
         */

        private int id;
        private String userid;
        private ObjectBean object;
        private String created_at;
        private List<UserListBean> user_list;

        @Data
        public static class ObjectBean implements Serializable {
            /**
             * prop1 : 1
             * prop2 : test
             */

            private int prop1;
            private String prop2;
        }

        @Data
        public static class UserListBean implements Serializable {
            /**
             * id : 2
             * name : 测试1
             */

            private String id;
            private String name;
        }
    }

    @Data
    public static class Test2Bean implements Serializable {
        /**
         * Prop2 : 值1
         */

        private String Prop2;
    }
}
