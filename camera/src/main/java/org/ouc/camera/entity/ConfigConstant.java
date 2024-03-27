package org.ouc.camera.entity;

/**
 * @Description: 常量类
 */

public class ConfigConstant {

    //性别
    public static final int GENDER_MAN = 1;
    public static final int GENDER_WOMAN = 2;
    //员工
    public static final String STAFF_YES = "0";
    public static final String STAFF_NO = "1";
    //进门摄像头
    public static final String ENTER_CAMERA_TYPE = "0";
    //出门摄像头
    public static final String OUT_CAMERA_TYPE = "1";
    //组长
    public static final String GROUP_LEADER_TYPE = "1";
    //主管
    public static final String DIRECTOR_LEADER_TYPE = "0";
    //消息通知状态
    public static final String NOTICE_YES = "1";
    //统计通知状态
    public static final String NOTICE_STATISTICS_YES = "1";
    //夏季作息
    public static final int SUMMER_REST = 1;
    //冬季作息
    public static final int WINTER_REST = 0;
    //夏季、冬季午休 开始时间
    public static final String REST_BEGIN = "12:00:00";
    //冬季午休 结束时间
    public static final String WINTER_REST_END = "13:00:00";
    //夏季午休 结束时间
    public static final String SUMMER_REST_END = "13:30:00";
    //摄像头图片比对成功结果
    public static final String CAMERA_CONTRAST_RESULT = "1";
    //钉钉访问Token的redis存储key名
    public static final String DINGTALK_ACESSTOKEN_REDIS_KEY = "camera:subscribe_access_token";
    //摄像头下发订阅id的redis存储key名
    public static final String CAMERA_CREATEDID_REDIS_KEY = "camera:subscribe_createdId";
    public static final Long AGENT_ID = 1212026360L;
    public static final String OP_USER_ID = "071807595223569741";

}
