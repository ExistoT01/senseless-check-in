package org.ouc.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.ouc.common.pojo.entity.Child;
import org.ouc.common.pojo.entity.Liuliang;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/liuliang")
public class liuliangController {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Liuliang getLiuLiang() {
        log.info("请求...");

        return new Liuliang("1", new Child[] {new Child("jiangjinda", "41542165542", "上班", "男", "技术部")});
    }

}
