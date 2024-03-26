package org.ouc.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clockin {
    private String name;
    private String id;
    private String times;
    private String time;
}
