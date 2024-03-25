package entity;

import lombok.Data;

import java.util.List;

@Data
public class Serch {
    @Data
    private class QueryInfos {
        private int QryType;

        private int QryCondition;

        private String QryData;
    }
    private int Num;

    private List<QueryInfos> QueryInfos ;

    private int Limit;

    private int Offset;

    public static void main(String[] args) {

    }


}

