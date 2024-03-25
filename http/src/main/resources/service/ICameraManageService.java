package org.ouc.http.src.main.resources.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.api.entity.GetFaceDatabaseIdVO;
import org.jeecg.modules.demo.cameramanage.entity.CameraManage;


public interface ICameraManageService extends IService<CameraManage> {
    //初始化摄像头订阅
    void initCamera(CameraManage cameraManage);
    GetFaceDatabaseIdVO getFaceDatabase(CameraManage cameraManage);
//    void addFaceInfo (CameraManage cameraManage, WxStaffInfo wxStaffInfo);
    CameraManage getByDeviceCode(String deviceId);
}
