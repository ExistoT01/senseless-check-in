package org.ouc.schedule.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ouc.common.pojo.entity.Clockin;
import org.ouc.common.pojo.entity.Daka;
import org.ouc.common.pojo.entity.Liuliang;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
            "e.id, " +
            "a.purp, " +
            "e.gender, " +
            "e.sec " +
            "FROM " +
            "access_event a " +
            "JOIN " +
            "employee_info e ON a.employee_id = e.id " +
            "WHERE " +
            "a.access_time BETWEEN #{date1} AND #{date2}")
    List<Liuliang> liuliangs(@Param("date1") String date1, @Param("date2") String date2);

    @Select("SELECT startTime, endTime, TIMESTAMPDIFF(SECOND, startTime, endTime) / 3600.0 AS time  FROM clock_in WHERE employee_id = #{id}")
    List<Daka> dakaid(String id);

    @Select("SELECT " +
            "e.name, " +
            "e.id, " +
            "CAST(COUNT(*) AS CHAR) AS times, " +
            "CAST(SUM(TIMESTAMPDIFF(SECOND, a.startTime, a.endTime) / 3600.0) AS CHAR) AS time " +
            "FROM " +
            "clock_in a " +
            "JOIN " +
            "employee_info e ON a.employee_id = e.id " +
            "GROUP BY " +
            "e.id, e.name")
    List<Clockin> daka();


    @Select("INSERT INTO clock_in (startTime, endTime, employee_id) VALUES (#{startTime}, #{endTime}, #{id})")
    void addclock_in(String id, Timestamp startTime, Timestamp  endTime);

    @Select("INSERT INTO access_event (access_time, purp, employee_id) VALUES (#{time}, #{purp}, #{id})")
    void addaccess(String id, Timestamp  time, String purp);



}
