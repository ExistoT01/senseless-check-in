package org.ouc.schedule.service;

import org.ouc.common.result.Result;
import org.ouc.common.pojo.entity.AccessEvent;
import org.ouc.schedule.mapper.AccessEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
