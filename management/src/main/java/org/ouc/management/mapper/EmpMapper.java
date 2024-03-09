package org.ouc.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ouc.common.pojo.entity.Employee;

@Mapper
public interface EmpMapper {

    @Select("select * from employees where id = #{id}")
    Employee getById(String id);

    @Insert("insert into employees (username, password, name, id_number, gender, phone_number, status, create_time, update_time)" +
            " values (#{username}, #{password}, #{name}, #{idNumber}, #{gender}, #{phoneNumber}, #{status}, #{createTime}, #{updateTime})")
    void insert(Employee employee);
}
