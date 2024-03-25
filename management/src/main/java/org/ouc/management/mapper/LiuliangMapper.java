package org.ouc.management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ouc.common.pojo.entity.TestLiuliang;

@Mapper
public interface LiuliangMapper {

    // @Select("select * from ")
    public TestLiuliang getLiuLiang();

}
