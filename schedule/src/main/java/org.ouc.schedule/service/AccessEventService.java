package org.ouc.schedule.service;

import org.ouc.common.pojo.entity.Clockin;
import org.ouc.common.pojo.entity.Daka;
import org.ouc.common.pojo.entity.Liuliang;
import org.ouc.common.result.Result;
import org.ouc.common.pojo.entity.AccessEvent;
import org.ouc.schedule.mapper.AccessEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class AccessEventService {

    @Autowired
    private AccessEventMapper accessEventMapper;


    public Result getTotalAccessCountByDate(String date) {
        return Result.success(accessEventMapper.getTotalAccessCountByDate(date));
    }

    public Result getTotalAccessCountByWeek(String date) {
        return Result.success(accessEventMapper.getTotalAccessCountByWeek(date));
    }

    public Result getTotalAccessCountByMonth(String date) {
        return Result.success(accessEventMapper.getTotalAccessCountByMonth(date));
    }


    public int liuliang(String date1, String date2) {
        return accessEventMapper.liuliang(date1, date2);
    }


    public List<Liuliang> liuliangs(String date1, String date2) {
        return accessEventMapper.liuliangs(date1, date2);
    }

    public List<Daka> dakaid(String id) {
        return accessEventMapper.dakaid(id);
    }

    public List<Clockin> daka() {
        return accessEventMapper.daka();
    }

    public Result addclock_in(String id, Timestamp startTime, Timestamp  endTime){
        accessEventMapper.addclock_in(id, startTime,  endTime);
        return Result.success();
    }

    public Result addaccess(String id, Timestamp  time, String purp){
        accessEventMapper.addaccess(id, time, purp);
        return Result.success();
    }

    public static LocalDateTime generateRandomDateTime() {
        // 生成一个随机的过去的时间点（例如，过去的一年内）
        Random random = new Random();
        long daysAgo = random.nextInt(365); // 过去0到364天
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime randomPastDateTime = now.minusDays(daysAgo);

        // 生成一天中的随机时间
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        int second = random.nextInt(60);
        LocalDateTime randomTimeOfDay = LocalDateTime.of(randomPastDateTime.getYear(), randomPastDateTime.getMonth(), randomPastDateTime.getDayOfMonth(), hour, minute, second);

        return randomTimeOfDay;
    }

    public static LocalDateTime generateRandomDateTimeAfter(LocalDateTime startTime) {
        // 生成一个随机的endTime，确保它大于startTime
        Random random = new Random();
        long secondsToAdd = random.nextInt(3600 * 24); // 最多加一天的时间（秒为单位）
        LocalDateTime endTime = startTime.plusSeconds(secondsToAdd);
        return endTime;
    }

}
