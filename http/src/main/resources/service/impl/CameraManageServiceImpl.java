package org.ouc.http.src.main.resources.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.demo.api.entity.CameraSubscribeInput;
import org.jeecg.modules.demo.api.entity.GetFaceDatabaseIdVO;
import org.jeecg.modules.demo.api.service.ICameraManageApiService;
import org.jeecg.modules.demo.cameramanage.entity.CameraManage;
import org.jeecg.modules.demo.cameramanage.entity.ConfigConstant;
import org.jeecg.modules.demo.cameramanage.mapper.CameraManageMapper;
import org.jeecg.modules.demo.cameramanage.service.ICameraManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 摄像头管理
 * @Author: jeecg-boot
 * @Date:   2024-02-19
 * @Version: V1.0
 */
@Service
public class CameraManageServiceImpl extends ServiceImpl<CameraManageMapper, CameraManage> implements ICameraManageService {

    @Autowired
    private ICameraManageApiService cameraManageApiService;

    @Autowired
    private RedisUtil redisUtil;

//    @Autowired
//    private IWxStaffInfoService wxStaffInfoService;

    @Value("${server.ip}")
    private String ip;

    @Value("${server.port}")
    private int port;

    /**
     * 摄像头获取订阅，设置刷新订阅
     * @param cameraManage
     * @return createId 订阅地址
     */
    @Override
    public void initCamera(CameraManage cameraManage) {
        CameraSubscribeInput cameraSubscribeInput = new CameraSubscribeInput();

        //设置本机ip，端口
        cameraSubscribeInput.setIpAddress(ip);
        cameraSubscribeInput.setPort(port);
        CameraSubscribeInput.SubscribePersonConditionBean subscribePersonCondition = new CameraSubscribeInput.SubscribePersonConditionBean();
        List<CameraSubscribeInput.SubscribePersonConditionBean.LibIDListBean> libIDList = new ArrayList<>();
        CameraSubscribeInput.SubscribePersonConditionBean.LibIDListBean libIDListBean = new CameraSubscribeInput.SubscribePersonConditionBean.LibIDListBean();
        //设置对应人脸库
        libIDListBean.setLibId(Long.parseLong(cameraManage.getLibId()));
        libIDList.add(libIDListBean);
        subscribePersonCondition.setLibIdList(libIDList);
        cameraSubscribeInput.setSubscribePersonCondition(subscribePersonCondition);

        //下发订阅id
        String createdId = cameraManageApiService.cameraSubscribe(cameraManage,cameraSubscribeInput);
        redisUtil.hset(ConfigConstant.CAMERA_CREATEDID_REDIS_KEY,cameraManage.getIp(),createdId,3500);
    }


    /**
     * 根据ip查询人脸库名称，id
     * @param cameraManage
     * @return List<Map<String,String> <人脸库名称/id>>
     */
    @Override
    public GetFaceDatabaseIdVO getFaceDatabase(CameraManage cameraManage) {
//        List<Map<String, String>> result = cameraManageApi.getFaceDatabaseId(cameraManage);
        return cameraManageApiService.getFaceDatabaseId(cameraManage) ;
    }

    @Override
    public CameraManage getByDeviceCode(String deviceId) {
        LambdaQueryWrapper<CameraManage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //lambdaQueryWrapper.eq(CameraManage::getDeviceCode, deviceId);
        return getOne(lambdaQueryWrapper);
    }
}
