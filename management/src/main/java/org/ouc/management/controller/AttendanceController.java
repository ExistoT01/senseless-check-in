package org.ouc.management.controller;

import org.ouc.common.result.Result;
import org.ouc.management.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/zaodaoTop")
    public Result getEarlyArrival() {
        return attendanceService.earlyArrivalTopFive();
    }

    @GetMapping("/chidaoTop")
    public Result getLateArrival() {
        return attendanceService.lateArrivalTopFive();
    }

    @GetMapping("/zaotuiTop")
    public Result getEarlyLeave() {
        return attendanceService.earlyLeaveTopFive();
    }

    @GetMapping("/jiabanTop")
    public Result getOverTime() {
        return attendanceService.overTimeTopFive();
    }

    @GetMapping("/queqinTop")
    public Result getAbsence() {
        return attendanceService.absencesTopFive();
    }
}
