package org.ouc.schedule.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ouc.common.pojo.entity.Liuliang;

import java.util.List;

@Mapper
public interface AccessEventMapper {

    @Select("SELECT COUNT(*) FROM access_event WHERE DATE(access_time) = #{date}")
    int getTotalAccessCountByDate(String date);

    @Select("SELECT COUNT(*) " +
            "FROM access_event " +
            "WHERE DATE(access_time) BETWEEN DATE_SUB(#{date}, INTERVAL WEEKDAY(#{date}) DAY) " +
            "AND DATE_ADD(#{date}, INTERVAL (6 - WEEKDAY(#{date})) DAY)")
    int getTotalAccessCountByWeek( String date);

    @Select("SELECT COUNT(*) " +
            "FROM access_event " +
            "WHERE YEAR(access_time) = YEAR(#{date}) " +
            "AND MONTH(access_time) = MONTH(#{date})")
    int getTotalAccessCountByMonth(String date);

    @Select("SELECT COUNT(*) " +
            "FROM access_event " +
            "WHERE access_time BETWEEN #{date1} AND #{date2}")
    int liuliang(String date1, String date2);

    @Select("SELECT " +
            "e.name, " +
            "e.id_number, " +
            "a.event_type AS '打卡目的', " +
            "e.gender, " +
            "e.sec " +
            "FROM " +
            "access_event a " +
            "JOIN " +
            "employees e ON a.idNumber = e.idNumber " +
            "WHERE " +
            "a.access_time BETWEEN #{date1} AND #{date2}")
    List<Liuliang> liuliangs(@Param("date1") String date1, @Param("date2") String date2);
}
