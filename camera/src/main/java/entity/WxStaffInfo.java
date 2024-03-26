package entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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

import java.util.Date;

@TableName("camera_wx_staff_info")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="wx_staff_info对象", description="网信人员信息表")
public class WxStaffInfo {
    
	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
	private String id;
	/**姓名*/
	@Excel(name = "姓名", width = 15)
    @ApiModelProperty(value = "姓名")
	private String name;
	/**电话*/
	@Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
	private String phone;
	/**部门id*/
	@Excel(name = "部门id", width = 15)
    @ApiModelProperty(value = "部门id")
	private String deptId;
	/**部门名称*/
	@Excel(name = "部门名称", width = 15)
    @ApiModelProperty(value = "部门名称")
	private String deptName;
	/**职位*/
	@Excel(name = "职位", width = 15)
    @ApiModelProperty(value = "职位")
	private String position;
	/**雇用时间*/
	@Excel(name = "雇用时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
//	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "雇用时间")
	private String hiredDate;
	/**图片，多个用都逗号隔开*/
	@Excel(name = "图片，多个用都逗号隔开", width = 15)
    @ApiModelProperty(value = "图片，多个用都逗号隔开")
	private String userImage;
	/**userid*/
	@Excel(name = "userid", width = 15)
	@ApiModelProperty(value = "userid")
	private String userIdDing;

	//	@Excel(name = "开始时间", width = 15)
	@TableField(exist = false)
	private String startTime;
//	@Excel(name = "结束时间", width = 15)
	@TableField(exist = false)
	private String endTime;
	//	@Excel(name = "申请开始时间", width = 15)
	@TableField(exist = false)
	private String phoneStartTime;
	//	@Excel(name = "申请结束时间", width = 15)
	@TableField(exist = false)
	private String photoEndTime;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
	@ApiModelProperty(value = "创建人")
	private String createUser;
	/**创建时间*/
	@Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建时间")
	private Date createDate;
	/**更新人*/
	@Excel(name = "更新人", width = 15)
	@ApiModelProperty(value = "更新人")
	private String updateUser;
	/**更新时间*/
	@Excel(name = "更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "更新时间")
	private Date updateDate;
	/**创建人IP*/
	@Excel(name = "创建人IP", width = 15)
	@ApiModelProperty(value = "创建人IP")
	private String createIp;
	/**更新人IP*/
	@Excel(name = "更新人IP", width = 15)
	@ApiModelProperty(value = "更新人IP")
	private String updateIp;

	/**工作外出消息是否通知（0：不通知 1：通知）*/
	@Excel(name = "工作外出消息是否通知", width = 15)
	@ApiModelProperty(value = "工作外出消息是否通知")
	private String noticeGoOut;
	/**工作外出统计是否通知（0：不通知 1：通知）*/
	@Excel(name = "工作外出统计是否通知", width = 15)
	@ApiModelProperty(value = "作外出统计是否通知")
	private String noticeGoOutStatistics;
	/**照片审核状态0：未审核 1审核通过 2审核失败*/
	@Excel(name = "照片审核状态", width = 15)
	@ApiModelProperty(value = "照片审核状态")
	private String userImageStatus;
	/**照片申请时间*/
	@Excel(name = "照片申请时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "照片申请时间")
	private Date photoApplicationTime;
	/**照片审核时间*/
	@Excel(name = "照片审核时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "照片审核时间")
	private Date photoExamineTime;

	/**管理或审核 0代表管理页面  1代表审核页面*/
	@TableField(exist = false)
	private String managementOrAudit = "0";

}
