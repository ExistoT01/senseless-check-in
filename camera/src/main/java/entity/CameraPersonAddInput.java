package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CameraPersonAddInput implements Serializable {

    private int Num;
    private List<PersonInfoListBean> PersonInfoList;

    @Data
    public static class PersonInfoListBean implements Serializable {

        //默认0自动生成personId
        private int PersonID = 0;
        private int LastChange = 0;
        private String PersonName;     //新增人员名称
        private int Gender = 0;             //性别
        private String Birthday = "";
        private RegionBean Region;
        private TimeTemplateBean TimeTemplate;
        private int IdentificationNum = 1;
        private int ImageNum = 1;
        private List<IdentificationListBean> IdentificationList;
        private List<ImageListBean> ImageList;

        @Data
        public static class RegionBean implements Serializable {

            private String Province;    //部门id
            private String City = "";
        }

        @Data
        public static class TimeTemplateBean implements Serializable {

            private int BeginTime = 0;
            private String EndTime = "4294967295";
            private int Index = 0;
        }

        @Data
        public static class IdentificationListBean implements Serializable {

            private int Type = 0;
            private String Number;       //手机号
        }

        @Data
        public static class ImageListBean implements Serializable {

            private int FaceID = 0;
            private String Name;       //人脸图片名称
            private Integer Size;           //大小
            private int Type = 1;
            private Long LastChange;    //图片最后更新时间
            private String Data;          //图片转换Base64码
        }
    }
}
