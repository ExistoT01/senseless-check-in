package org.ouc.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateStringDto implements Serializable {
    private List<String> dateString;

    // 标准的getter和setter方法
    public List<String> getDateString() {
        return dateString;
    }

    public void setDateString(List<String> dateString) {
        this.dateString = dateString;
    }
}
