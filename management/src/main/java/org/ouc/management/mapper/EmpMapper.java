package org.ouc.management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ouc.common.pojo.entity.Employee;

@Mapper
public interface EmpMapper {

    @Select("select * from employees where id = #{id}")
    Employee getById(String id);
}
