package org.ouc.management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ouc.common.pojo.entity.Liuliang;

@Mapper
public interface LiuliangMapper {

    // @Select("select * from ")
    public Liuliang getLiuLiang();

}
