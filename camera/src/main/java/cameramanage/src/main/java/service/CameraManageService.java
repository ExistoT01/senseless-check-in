package cameramanage.src.main.java.service;
import VO.GetFaceDatabaseIdVO;
import com.baomidou.mybatisplus.extension.service.IService;
import entity.CameraManage;
import entity.WxStaffInfo;

public interface CameraManageService extends IService<CameraManage> {


    //初始化摄像头订阅
    void initCamera(CameraManage cameraManage);
}
