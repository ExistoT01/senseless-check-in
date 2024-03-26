package org.ouc.management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ouc.common.pojo.dto.AttendanceDTO;

import java.util.List;

@Mapper
public interface AttendanceMapper {


    @Select("select * from employee_attendance ea left join employee_info ei on ea.employee_id = ei.id order by early_arrivals desc limit 5")
    List<AttendanceDTO> earlyArrivalTopFive();

    @Select("select * from employee_attendance ea left join employee_info ei on ea.employee_id = ei.id order by late_arrivals desc limit 5")
    List<AttendanceDTO> lateArrivalTopFive();

    @Select("select * from employee_attendance ea left join employee_info ei on ea.employee_id = ei.id order by early_leaves desc limit 5")
    List<AttendanceDTO> earlyLeaveTopFive();

    @Select("select * from employee_attendance ea left join employee_info ei on ea.employee_id = ei.id order by overtime desc limit 5")
    List<AttendanceDTO> overTimeTopFive();

    @Select("select * from employee_attendance ea left join employee_info ei on ea.employee_id = ei.id order by absences desc limit 5")
    List<AttendanceDTO> absencesTopFive();
}
