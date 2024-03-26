package org.ouc.camera.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CameraGetPersonIdInput implements Serializable {

    private int num = 1;
    private int limit = 3;
    private int offset = 0;
    private List<QueryInfosBean> queryInfos;

    @Data
    public static class QueryInfosBean implements Serializable {

        private int qryType;
        private int qryCondition;
        private String qryData;
    }
}
