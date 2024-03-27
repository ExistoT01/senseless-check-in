package org.ouc.http.src.main.resources.service;

//import org.ouc.camera.src.main.java.org.ouc.camera.entity.CameraFaceInfo;
import org.ouc.camera.src.main.java.org.ouc.camera.entity.*;
import org.ouc.http.src.main.resources.vo.CameraCallBackVo;


public interface ICameraResponseService {

    CameraFaceInfo cameraCallBackInfoSave(CameraCallBackVo cameraCallBackVo);

    CameraImage cameraImageInfo(CameraCallBackVo cameraCallBackVo);
}
