package org.ouc.camera.src.main.java.org.ouc.camera.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @Description: 摄像头人脸信息
 */

@Data
@TableName("camera_face_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="camera_face_info对象", description="摄像头人脸信息")
public class CameraFaceInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private String sysOrgCode;
	/**姓名*/
	@Excel(name = "姓名", width = 15)
    @ApiModelProperty(value = "姓名")
    private String name;
	/**性别*/
	@Excel(name = "性别", width = 15)
    @ApiModelProperty(value = "性别")
    private String gender;
	/**相似度*/
	@Excel(name = "相似度", width = 15)
    @ApiModelProperty(value = "相似度")
    private Integer similar;
	/**抓拍时间（小时）*/
	@Excel(name = "抓拍时间（小时）", width = 15)
    @ApiModelProperty(value = "抓拍时间（小时）")
    private String passtime;
	/**抓拍时间（日期）*/
	@Excel(name = "抓拍时间（日期）", width = 15)
    @ApiModelProperty(value = "抓拍时间（日期）")
    private String date;
	/**抓拍时间*/
	@Excel(name = "抓拍时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "抓拍时间")
    private java.util.Date passdate;
	/**年龄*/
	@Excel(name = "年龄", width = 15)
    @ApiModelProperty(value = "年龄")
    private String age;
	/**小图形url*/
	@Excel(name = "小图像url", width = 15)
    @ApiModelProperty(value = "小图像url")
    private String image;
	/**0:进门 1：出门*/
	@Excel(name = "0:进门 1：出门", width = 15)
    @ApiModelProperty(value = "0:进门 1：出门")
    private String type;
	/**开始时间*/
	@Excel(name = "开始时间", width = 15)
    @ApiModelProperty(value = "开始时间")
    private String starttime;
	/**结束时间*/
	@Excel(name = "结束时间", width = 15)
    @ApiModelProperty(value = "结束时间")
    private String endtime;
	/**0：员工 1：陌生人*/
	@Excel(name = "0：员工 1：陌生人", width = 15)
    @ApiModelProperty(value = "0：员工 1：陌生人")
    private String staff;
	/**开始照片*/
	@Excel(name = "开始照片", width = 15)
    @ApiModelProperty(value = "开始照片")
    private String startimage;
	/**结束照片*/
	@Excel(name = "结束照片", width = 15)
    @ApiModelProperty(value = "结束照片")
    private String endimage;
	/**时长*/
	@Excel(name = "时长", width = 15)
    @ApiModelProperty(value = "时长")
    private String duration;
	/**部门*/
	@Excel(name = "部门", width = 15)
    @ApiModelProperty(value = "部门")
    private String deptname;
	/**职位*/
	@Excel(name = "职位", width = 15)
    @ApiModelProperty(value = "职位")
    private String position;
	/**用户id*/
	@Excel(name = "用户id", width = 15)
    @ApiModelProperty(value = "用户id")
    private String userid;
	/**部门id*/
	@Excel(name = "部门id", width = 15)
    @ApiModelProperty(value = "部门id")
    private String deptid;
	/**设备号*/
	@Excel(name = "设备号", width = 15)
    @ApiModelProperty(value = "设备号")
    private String deviceid;
	/**时间*/
	@Excel(name = "时间", width = 15)
    @ApiModelProperty(value = "时间")
    private Double datetimestamp;
	/**日期维度*/
	@Excel(name = "日期维度", width = 15)
    @ApiModelProperty(value = "日期维度")
    private String datedimension;
}
