package org.ouc.http.src.main.resources.service;

import org.jeecg.modules.demo.camera.entity.CameraFaceInfo;
import org.jeecg.modules.demo.camera.entity.CameraImage;
import org.jeecg.modules.demo.cameramanage.vo.CameraCallBackVo;


public interface ICameraResponseService {

    CameraFaceInfo cameraCallBackInfoSave(CameraCallBackVo cameraCallBackVo);

    CameraImage cameraImageInfo(CameraCallBackVo cameraCallBackVo);
}
