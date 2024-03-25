package org.ouc.management.controller;

import org.ouc.common.pojo.entity.Zhuapai;
import org.ouc.common.pojo.entity.ZhuapaiChild;
import org.ouc.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zhuapai")
public class zhuapaiController {

    @GetMapping
    public Result zhuapai() {

        ZhuapaiChild child = new ZhuapaiChild("https://expicture.oss-cn-beijing.aliyuncs.com/uqaqhuvavt0.jpg", "0-1-0", "img_001");
        ZhuapaiChild child1 = new ZhuapaiChild("https://expicture.oss-cn-beijing.aliyuncs.com/202321859555992.jpg", "0-1-1", "img_002");
        Zhuapai zhuapai = new Zhuapai(new ZhuapaiChild[]{child, child1}, "0-1", "zhuapai_001");


        List<Zhuapai> list = new ArrayList<>();
        list.add(zhuapai);

        return Result.success(list);
    }
}
