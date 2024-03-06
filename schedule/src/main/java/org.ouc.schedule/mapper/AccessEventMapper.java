package org.ouc.schedule.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
