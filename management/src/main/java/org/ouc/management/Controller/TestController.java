package org.ouc.management.Controller;

import lombok.extern.slf4j.Slf4j;
import org.ouc.common.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@Slf4j
public class TestController {
    // @PostMapping
    // public Result callback(@RequestBody Guy guy) {
    //     log.info("测试接口, json数据: {}", guy);
    //     return Result.success(guy);
    // }

    @GetMapping
    public Result test() {
        log.info("测试接口, 直接返回成功响应");
        return Result.success();
    }
}
