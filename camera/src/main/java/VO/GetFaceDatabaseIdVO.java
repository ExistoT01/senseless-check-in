package VO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetFaceDatabaseIdVO implements Serializable{
    private List<libIdListBean> libIdList;

    @Data
    public static class libIdListBean implements Serializable {
        private String name;
        private long libId;
    }
}
