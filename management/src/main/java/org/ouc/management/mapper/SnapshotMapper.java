package org.ouc.management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ouc.common.pojo.entity.Zhuapai;
import org.ouc.common.pojo.entity.ZhuapaiChild;

import java.util.List;

@Mapper
public interface SnapshotMapper {
    @Select("select imgurl, imagekey as 'key', title from cameras_photo")
    ZhuapaiChild[] getSnapshots();

    @Select("select camerakey as 'key', name as 'title' from shebei_info")
    Zhuapai getCamera();
}
