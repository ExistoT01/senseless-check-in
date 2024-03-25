package org.ouc.schedule.service;

import org.ouc.common.pojo.entity.Liuliang;
import org.ouc.common.result.Result;
import org.ouc.common.pojo.entity.AccessEvent;
import org.ouc.schedule.mapper.AccessEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
}
