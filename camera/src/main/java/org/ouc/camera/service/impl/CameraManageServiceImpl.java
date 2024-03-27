package org.ouc.camera.service.impl;


import cameraapi.service.CameraApiService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ouc.camera.entity.CameraManage;
import org.ouc.camera.entity.CameraSubscribeInput;
import org.ouc.camera.mapper.CameraManageMapper;
import org.ouc.camera.service.CameraManageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.ouc.camera.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



/**
 * @Description: 摄像头管理
 *
 */
@Service
@ComponentScan("cameraapi.service")
public class CameraManageServiceImpl extends ServiceImpl<CameraManageMapper, CameraManage> implements CameraManageService {

    @Autowired
    private CameraManageMapper cameraManageMapper;
//    @Autowired
//    private CameraApiService cameraManageApiService;

   /* @Autowired
    private CameraManageMapper cameraManageMapper;*/
    
    /*@Autowired
    private RedisUtil redisUtil;*/


   /* @Value("${server.ip}")*/
    private String ip;

    //@Value("${server.port}"//
    private int port;

    /**
     * 摄像头获取订阅，设置刷新订阅
     * @param
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

//        //下发订阅id
       // String createdId = cameraManageApiService.cameraSubscribe(cameraManage,cameraSubscribeInput);
//        redisUtil.hset(ConfigConstant.CAMERA_CREATEDID_REDIS_KEY,cameraManage.getIp(),createdId,3500);

    }
    @Override
    public PageVo list(Integer page, Integer size){
        Page<CameraManage> cameraManagePage =new Page<>(page,size);
        Page<CameraManage> resultPage = this.cameraManageMapper.selectPage(cameraManagePage, null);
        PageVo pageVo = new PageVo();
        pageVo.setTotal(resultPage.getTotal());
        pageVo.setData(resultPage.getRecords());
        return pageVo;
    }
    @Override
    public String ttt(){
        String str="aaaaaaa";
        return str;
    }



}

