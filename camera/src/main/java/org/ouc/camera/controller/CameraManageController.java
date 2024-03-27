package org.ouc.camera.controller;




import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.ouc.camera.entity.CameraManage;
import org.ouc.camera.service.CameraManageService;
import org.ouc.camera.util.ResultVOUtil;
import org.ouc.camera.vo.PageVo;
import org.ouc.camera.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cameramanage")
public class CameraManageController {
    @Autowired
    private CameraManageService cameraManageService;

        @GetMapping("/te")
        public String testee(){

            String str=this.cameraManageService.ttt();

            return str;
        }

    /**
     * 摄像头设备查询
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @GetMapping("/list")
    public ResultVo list(@RequestParam(name = "pageNo", defaultValue = "1")
                                Integer pageNo,
                         @RequestParam(name = "pageSize", defaultValue = "10")
                                Integer pageSize,
                         HttpServletRequest req) {
        PageVo pageVo = this.cameraManageService.list(pageNo,pageSize);
        return ResultVOUtil.success(pageVo);
    }

    /**
     * 摄像头添加
     * @param cameraManage
     * @return
     */
    @PostMapping("/add")
    public ResultVo add(@RequestBody CameraManage cameraManage) {
        cameraManageService.save(cameraManage);
        System.out.println("aaa");
        return ResultVOUtil.success(null);

    }

    /**
     * 摄像头设备信息修改
     * @param cameraManage
     * @return
     */
    @PostMapping("/edit")
    public ResultVo edit(@RequestBody CameraManage cameraManage) {
        cameraManageService.updateById(cameraManage);
        return ResultVOUtil.success(null);
    }

    /**
     * 摄像头设备删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public ResultVo delete(@RequestParam(name = "id", required = true) String id) {
        cameraManageService.removeById(id);
        return ResultVOUtil.success(null);
    }

    /**
     * 查询摄像头通过ID
     * @param id
     * @return
     */
    @GetMapping("/findByID")
    public ResultVo queryById(@RequestParam(name = "id", required = true) String id) {
        CameraManage cameraManage = cameraManageService.getById(id);
        if (cameraManage == null) {
            return  ResultVOUtil.fail();
        }
        return ResultVOUtil.success(null);
    }

    /**
     * 初始化摄像头
     * @param cameraId
     * @return
     */

    @GetMapping("/initCamer")
    public ResultVo initCamera(@RequestParam(name = "id", required = true) String cameraId) {

        LambdaQueryWrapper<CameraManage> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CameraManage::getId, cameraId);
        CameraManage cameraManage = cameraManageService.getOne(queryWrapper);

        //初始化订阅
        cameraManageService.initCamera(cameraManage);
        return  ResultVOUtil.success(null);
    }


}
