package org.ouc.http.src.main.resources.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.modules.demo.cameramanage.service.ICameraResponseService;
import org.jeecg.modules.demo.cameramanage.vo.CameraCallBackVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 接收摄像头订阅
 */

@Slf4j
@Api(tags="摄像头回调信息")
@RestController
@RequestMapping("/LAPI/V1.0/System/Event/Notification")
public class CameraResponseController {
    @Autowired
    private ICameraResponseService iCameraResponseService;
    @AutoLog(value = "摄像头回调信息处理")
    @ApiOperation(value="摄像头回调信息处理", notes="摄像头回调信息处理")
    @PostMapping(value = "/PersonInfo")
    public Result<?> add(@RequestBody String jsonStr) {
        CameraCallBackVo cameraCallBackVo = JSON.parseObject(jsonStr, CameraCallBackVo.class);
        log.info("==============");
        iCameraResponseService.cameraCallBackInfoSave(cameraCallBackVo);
        return null;
    }

}
