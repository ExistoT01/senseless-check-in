package VO;

import lombok.Data;

import java.util.List;

@Data
public class SerchVO {
    @lombok.Data
    public class Region {
        private String Nation="wo";

        private String Province;

        private String City;
    }
    @lombok.Data
    public class TimeTemplate {
        private int BeginTime;

        private int EndTime;

        private int Index;
    }
    @lombok.Data
    public class IdentificationList {
        private int Type;

        private String Number;
    }
    @lombok.Data
    public class ImageList {
        private int FaceID;

        private String Name;

        private int Size;

        private String Data;
    }
    @lombok.Data
    public class PersonInfoList {
        private int PersonID;

        private int LastChange;

        private String PersonName;

        private int Gender;

        private String Birthday;

        private Region Region;

        private TimeTemplate TimeTemplate;

        private int IdentificationNum;

        private List<IdentificationList> IdentificationList;

        private int ImageNum;

        private List<ImageList> ImageList;
    }
    @lombok.Data
    public class PersonList {
        private int Num;

        private List<PersonInfoList> PersonInfoList;
    }
    @lombok.Data
    public class Data {
        private int Total;

        private int Offset;

        private PersonList PersonList;
    }
    @lombok.Data
    public class Response {
        private String ResponseURL;

        private int CreatedID;

        private int ResponseCode;

        private int SubResponseCode;

        private String ResponseString;

        private int StatusCode;

        private String StatusString;

        private Data Data;
    }
    private Response Response;
    }
