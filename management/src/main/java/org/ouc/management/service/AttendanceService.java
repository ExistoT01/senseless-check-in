package org.ouc.management.service;

import org.ouc.common.pojo.dto.AttendanceDTO;
import org.ouc.common.result.Result;
import org.ouc.management.mapper.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;


    public Result earlyArrivalTopFive() {
        List<AttendanceDTO> attendanceDTOS = attendanceMapper.earlyArrivalTopFive();
        for (int i = 0; i < attendanceDTOS.size(); i++) {
            attendanceDTOS.get(i).setRank(String.valueOf(i + 1));
        }
        return Result.success(attendanceDTOS);
    }

    public Result lateArrivalTopFive() {
        List<AttendanceDTO> attendanceDTOS = attendanceMapper.lateArrivalTopFive();
        for (int i = 0; i < attendanceDTOS.size(); i++) {
            attendanceDTOS.get(i).setRank(String.valueOf(i + 1));
        }
        return Result.success(attendanceDTOS);
    }

    public Result earlyLeaveTopFive() {
        List<AttendanceDTO> attendanceDTOS = attendanceMapper.earlyLeaveTopFive();
        for (int i = 0; i < attendanceDTOS.size(); i++) {
            attendanceDTOS.get(i).setRank(String.valueOf(i + 1));
        }
        return Result.success(attendanceDTOS);
    }

    public Result overTimeTopFive() {
        List<AttendanceDTO> attendanceDTOS = attendanceMapper.overTimeTopFive();
        for (int i = 0; i < attendanceDTOS.size(); i++) {
            attendanceDTOS.get(i).setRank(String.valueOf(i + 1));
        }
        return Result.success(attendanceDTOS);
    }

    public Result absencesTopFive() {
        List<AttendanceDTO> attendanceDTOS = attendanceMapper.absencesTopFive();
        for (int i = 0; i < attendanceDTOS.size(); i++) {
            attendanceDTOS.get(i).setRank(String.valueOf(i + 1));
        }
        return Result.success(attendanceDTOS);
    }
}
