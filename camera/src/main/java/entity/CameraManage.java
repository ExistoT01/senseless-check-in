package entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@TableName("camera_manage")  //对应数据库中摄像头管理的名字
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="camera_manage对象", description="摄像头管理")
public class CameraManage {
    private static final long serialVersionUID = 1L;

    /**主键*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
    /**名称*/

    @ApiModelProperty(value = "名称")
    private java.lang.String name;
    /**ip地址*/

    @ApiModelProperty(value = "ip地址")
    private java.lang.String ip;
    /**设备号*/

    @ApiModelProperty(value = "设备号")
    private java.lang.String deviceCode;
    /**人脸库id*/

    @ApiModelProperty(value = "人脸库id")
    private java.lang.String libId;
    /**摄像头类型 0:进门 1：出门*/

    @ApiModelProperty(value = "摄像头类型 0:进门 1：出门")
    private java.lang.String type;
    /**创建人*/

    @ApiModelProperty(value = "创建人")
    private java.lang.String createUser;
    /**创建时间*/

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createDate;
    /**更新人*/

    @ApiModelProperty(value = "更新人")
    private java.lang.String updateUser;
    /**更新时间*/

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateDate;
    /**创建人IP*/

    @ApiModelProperty(value = "创建人IP")
    private java.lang.String createIp;
    /**更新人IP*/

    @ApiModelProperty(value = "更新人IP")
    private java.lang.String updateIp;
    /**备注*/

    @ApiModelProperty(value = "备注")
    private java.lang.String remarks;
}
