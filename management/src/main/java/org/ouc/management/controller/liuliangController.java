package org.ouc.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.ouc.common.pojo.entity.Child;
import org.ouc.common.pojo.entity.Liuliang;
import org.ouc.common.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/liuliang")
public class liuliangController {

    // @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Result getLiuLiang() {
        log.info("请求...");

        // return Result.success();

        Child child = new Child("男", "41542165542", "姜景达", "上班", "技术部");

        Liuliang liuliang = new Liuliang("1", new Child[]{child});
        return Result.success(liuliang);
    }

}
