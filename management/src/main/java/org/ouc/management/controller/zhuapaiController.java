package org.ouc.management.controller;

import org.ouc.common.pojo.entity.Zhuapai;
import org.ouc.common.pojo.entity.ZhuapaiChild;
import org.ouc.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zhuapai")
public class zhuapaiController {

    @GetMapping
    public Result zhuapai() {

        ZhuapaiChild child = new ZhuapaiChild("img_001", "id_001", "https://expicture.oss-cn-beijing.aliyuncs.com/uqaqhuvavt0.jpg");
        Zhuapai zhuapai = new Zhuapai(new ZhuapaiChild[]{child}, "id_001", "zhuapai_001");

        return Result.success(zhuapai);
    }
}
