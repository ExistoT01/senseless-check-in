package org.ouc.management.service;

import org.ouc.common.pojo.entity.Zhuapai;
import org.ouc.common.pojo.entity.ZhuapaiChild;
import org.ouc.common.result.Result;
import org.ouc.management.mapper.SnapshotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnapshotService {
    @Autowired
    private SnapshotMapper snapshotMapper;

    public Result getSnapShot() {
        ZhuapaiChild[] photos = snapshotMapper.getSnapshots();
        Zhuapai camera = snapshotMapper.getCamera();

        camera.setChildren(photos);

        ArrayList<Zhuapai> list = new ArrayList<>();
        list.add(camera);

        return Result.success(list);
    }
}
