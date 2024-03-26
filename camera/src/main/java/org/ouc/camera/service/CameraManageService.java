package org.ouc.camera.service;
import org.ouc.camera.entity.CameraManage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ouc.camera.vo.PageVo;

public interface CameraManageService extends IService<CameraManage> {


    //初始化摄像头订阅
    void initCamera(CameraManage cameraManage);
    public PageVo list(Integer page, Integer size);
    public String ttt();

}
