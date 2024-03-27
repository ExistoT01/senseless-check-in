package org.ouc.camera.vo;
import lombok.Data;

/**
 * 模板，取结果
 */
@Data
public class ResultVo<T> {
    private Integer code;
    private T data;
}
