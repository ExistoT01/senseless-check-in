package org.ouc.http.src.main.resources.service.impl;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecg.modules.demo.api.service.ICameraManageApiService;
import org.jeecg.modules.demo.camera.entity.CameraFaceInfo;
import org.jeecg.modules.demo.camera.entity.CameraImage;
import org.jeecg.modules.demo.cameramanage.entity.CameraManage;
import org.jeecg.modules.demo.cameramanage.entity.ConfigConstant;
import org.jeecg.modules.demo.cameramanage.mapper.CameraStatisticsMapper;
import org.jeecg.modules.demo.cameramanage.service.ICameraManageService;
import org.jeecg.modules.demo.cameramanage.service.ICameraResponseService;
import org.jeecg.modules.demo.cameramanage.vo.CameraCallBackVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CameraResponseServiceImpl implements ICameraResponseService {

    @Autowired
    private ICameraManageService iCameraManageService;
    @Autowired
    private org.jeecg.modules.demo.camera.service.ICameraFaceInfoService cameraFaceInfoService;
    @Autowired
    private ICameraManageApiService cameraManageApiService;
    @Autowired
    private org.jeecg.modules.demo.camera.mapper.CameraFaceInfoMapper cameraFaceInfoMapper;
    @Autowired
    private CameraStatisticsMapper cameraStatisticsMapper;

    @Override
    public CameraFaceInfo cameraCallBackInfoSave(CameraCallBackVo cameraCallBackVo) {
        CameraFaceInfo cameraFaceInfo = new CameraFaceInfo();

        //姓名
        String name = cameraCallBackVo.getPersonEventInfo().getFaceInfoList().get(0).getCompareInfo().getPersonInfo().getPersonName();
        cameraFaceInfo.setName(name);

        //性别 判断 0,1,2  未知，男性，女性
        int genderCode = cameraCallBackVo.getPersonEventInfo().getFaceInfoList().get(0).getCompareInfo().getPersonInfo().getGender();
        String gender = "";
        if(genderCode == ConfigConstant.GENDER_MAN) {
            gender= "男";
        } else if(genderCode == ConfigConstant.GENDER_WOMAN) {
            gender = "女";
        }
        cameraFaceInfo.setGender(gender);

        //相似度
        int similarity = cameraCallBackVo.getPersonEventInfo().getFaceInfoList().get(0).getCompareInfo().getSimilarity();
        cameraFaceInfo.setSimilar(similarity);

        Date cameraCallBackDate = new Date((long) (cameraCallBackVo.getPersonEventInfo().getTimestamp() * 1000));
        cameraFaceInfo.setDatetimestamp(cameraCallBackVo.getPersonEventInfo().getTimestamp());
        //抓拍时间 小时
        String hourTimeStr = DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(cameraCallBackDate);
        cameraFaceInfo.setPasstime(hourTimeStr);

        //抓拍时间 日期
        String dayTimeStr = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(cameraCallBackDate);
        cameraFaceInfo.setDate(dayTimeStr);

        //抓拍时间 data
        cameraFaceInfo.setPassdate(cameraCallBackDate);

        //todo 小图像处理 url http://10.200.2.192:8000/ipc_img/1624354645753.png
//        String imageName = cameraCallBackInfo.getPersonEventInfo().getFaceInfoList().get(0).getCompareInfo().getSnapshotImage().getSmallImage().getName();
        String base64Code = cameraCallBackVo.getPersonEventInfo().getFaceInfoList().get(0).getCompareInfo().getSnapshotImage().getSmallImage().getData();
        //base64码转换图片格式
        String imageUrl = "";

        imageUrl = cameraManageApiService.tranBase64ToImage(base64Code);
        cameraFaceInfo.setImage(imageUrl);

        //进出门类型 通过设备编码查询数据库获取设备进出门类型 0进门|1出门 ,并设置设备号
        CameraManage cameraManage = iCameraManageService.getByDeviceCode(cameraCallBackVo.getDeviceCode());
        cameraFaceInfo.setType(cameraManage.getType());
        cameraFaceInfo.setDeviceid(cameraCallBackVo.getDeviceCode());

//        //todo 人员类型 员工 0|陌生人 1
//        int typeCode = cameraCallBackVo.getPersonEventInfo().getFaceInfoList().get(0).getType();
//        String staffType;
//        if(typeCode == 1) {
//            //内部人员
//            staffType = ConfigConstant.STAFF_YES;
//        }else {
//            //未识别 0，比对失败 2 ;置为1
//            staffType = ConfigConstant.STAFF_NO;
//        }
//        cameraFaceInfo.setStaff(staffType);


        //人员部门id
        String deptId = cameraCallBackVo.getPersonEventInfo().getFaceInfoList().get(0).getCompareInfo().getPersonInfo().getRegion().getProvince();
        cameraFaceInfo.setDeptid(deptId);

        //写入数据库
        cameraFaceInfoMapper.insert(cameraFaceInfo);
        return cameraFaceInfo;
    }

    @Override
    public CameraImage cameraImageInfo(CameraCallBackVo cameraCallBackVo) {
        CameraImage cameraImage = new CameraImage();
        CameraImage.ImageListBean imageListBean = new CameraImage.ImageListBean();

        cameraImage.setTitle(cameraCallBackVo.getPersonEventInfo().getCameraTitle());

        String imageName = cameraCallBackVo.getPersonEventInfo().getFaceInfoList().get(0).getCompareInfo().getSnapshotImage().getSmallImage().getName();
        imageListBean.setTitle(imageName);

        String base64Code = cameraCallBackVo.getPersonEventInfo().getFaceInfoList().get(0).getCompareInfo().getSnapshotImage().getSmallImage().getData();
        //base64码转换图片格式
        String imageUrl = "";
        imageUrl = cameraManageApiService.tranBase64ToImage(base64Code);
        imageListBean.setImgUrl(imageUrl);

        cameraImage.setChildren(imageListBean);

        return cameraImage;
    }
}
