package cameramanage.src.main.java.controller;



import cameramanage.src.main.java.service.CameraManageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.CameraManage;
import jakarta.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController



@RequestMapping("/cameramanage")
public class CameraManageController extends JeecgController<CameraManage, CameraManageService> {



    @Autowired
    private CameraManageService cameraManageService;

    /**
     * 摄像头设备查询
     * @param cameraManage
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    @GetMapping("/list")
    public Result<?> cameraList(CameraManage cameraManage,
                                @RequestParam(name = "pageNo", defaultValue = "1")
                                Integer pageNo,
                                @RequestParam(name = "pageSize", defaultValue = "10")
                                Integer pageSize,
                                HttpServletRequest req) {
        QueryWrapper<CameraManage> queryWrapper = QueryGenerator.initQueryWrapper(cameraManage, req.getParameterMap());
        Page<CameraManage> page = new Page<CameraManage>(pageNo, pageSize);
        IPage<CameraManage> pageList = cameraManageService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 摄像头添加
     * @param cameraManage
     * @return
     */
    @PostMapping("/add")
    public Result<?> add(@RequestBody CameraManage cameraManage) {
        cameraManageService.save(cameraManage);
        return Result.OK("添加成功！");

    }

    /**
     * 摄像头设备信息修改
     * @param cameraManage
     * @return
     */
    @PostMapping("/edit")
    public Result<?> edit(@RequestBody CameraManage cameraManage) {
        cameraManageService.updateById(cameraManage);
        return Result.OK("编辑成功!");
    }

    /**
     * 摄像头设备删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        cameraManageService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 查询摄像头通过ID
     * @param id
     * @return
     */
    @GetMapping("/findByID")
    public Result<?> queryById(@RequestParam(name = "id", required = true) String id) {
        CameraManage cameraManage = cameraManageService.getById(id);
        if (cameraManage == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(cameraManage);
    }

    /**
     * 初始化摄像头
     * @param cameraId
     * @return
     */

    @GetMapping("/initCamer")
    public Result<?> initCamera(@RequestParam(name = "id", required = true) String cameraId) {

        LambdaQueryWrapper<CameraManage> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CameraManage::getId, cameraId);
        CameraManage cameraManage = cameraManageService.getOne(queryWrapper);

        //初始化订阅
        cameraManageService.initCamera(cameraManage);
        return Result.OK("摄像头初始化成功！后台同步人脸库");
    }


}
