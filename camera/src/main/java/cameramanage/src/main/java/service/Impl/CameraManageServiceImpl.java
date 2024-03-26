package cameramanage.src.main.java.service.Impl;

import VO.GetFaceDatabaseIdVO;
import cameramanage.src.main.java.mapper.CameraManageMapper;
import cameramanage.src.main.java.service.CameraManageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import entity.CameraManage;
import entity.CameraSubscribeInput;
import entity.ConfigConstant;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.util.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import service.CameraApiService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description: 摄像头管理
 */
@Service
public class CameraManageServiceImpl extends ServiceImpl<CameraManageMapper, CameraManage> implements CameraManageService {

    @Autowired
    private CameraApiService cameraManageApiService;
    
    @Autowired
    private RedisUtil redisUtil;


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


}

