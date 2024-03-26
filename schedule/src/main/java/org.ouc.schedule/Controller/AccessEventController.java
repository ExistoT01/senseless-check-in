package org.ouc.schedule.Controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.ouc.common.pojo.dto.DateStringDto;
import org.ouc.common.pojo.entity.Clockin;
import org.ouc.common.pojo.entity.Daka;
import org.ouc.common.pojo.entity.Liuliang;
import org.ouc.common.result.Result;
import org.ouc.schedule.service.AccessEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/accessEvent")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class AccessEventController {

    @Autowired
    private AccessEventService accessEventService;

    @GetMapping(value = "/getTotalAccessCountByDate/{date}")
    public Result<Integer> getTotalAccessCountByDate(@PathVariable String date) {
        return accessEventService.getTotalAccessCountByDate(date);
    }


    @GetMapping(value = "/getTotalAccessCountByWeek/{date}")
    public Result<Integer> getTotalAccessCountByWeek(@PathVariable String date) {
        return accessEventService.getTotalAccessCountByWeek(date);
    }


    @GetMapping(value = "/getTotalAccessCountByMonth/{date}")
    public Result<Integer> getTotalAccessCountByMonth(@PathVariable String date) {
        return accessEventService.getTotalAccessCountByMonth(date);
    }

    @PostMapping(value = "/liuliang")
    public Map<String, Object> liuliang(@RequestBody ArrayList<String> dateStringDto) {



        int size = accessEventService.liuliang(dateStringDto.get(0), dateStringDto.get(1));
        List<Liuliang> l = accessEventService.liuliangs(dateStringDto.get(0), dateStringDto.get(1));
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("total", size); // 总人流量为员工数量
        responseData.put("children", l); // 员工列表作为children的值

        return responseData;
    }

    @GetMapping(value = "/dakaid/{id}")
    public List<Daka> dakaid(@PathVariable String id) {
        List<Daka> l = accessEventService.dakaid(id);
        for (Daka daka : l) {
            // 检查time是否为null或空字符串，以避免NullPointerException
            if (daka.getTime() != null && !daka.getTime().isEmpty()) {
                // 在time后面添加字符'h'
                daka.setTime(daka.getTime() + "h");
            }
        }
//        Map<String, Object> responseData = new HashMap<>();
//        responseData.put("children", l); // 员工列表作为children的值
        return l;
    }

    @GetMapping(value = "/daka")
    public List<Clockin> daka() {
        List<Clockin> l = accessEventService.daka();
        for (Clockin daka : l) {
            // 检查time是否为null或空字符串，以避免NullPointerException
            if (daka.getTime() != null && !daka.getTime().isEmpty()) {
                // 在time后面添加字符'h'
                daka.setTime(daka.getTime() + "h");
            }
        }
//        Map<String, Object> responseData = new HashMap<>();
//        responseData.put("children", l); // 员工列表作为children的值
        return l;
    }

    @GetMapping(value = "/clockin/{ids}")
    public Result<Integer> clockin(@PathVariable String ids) {

        String[] idArray = ids.split(",");
        for (String i : idArray) {
            LocalDateTime startTime = accessEventService.generateRandomDateTime();
            LocalDateTime endTime = accessEventService.generateRandomDateTimeAfter(startTime);

            // 将LocalDateTime转换为Timestamp，以便与数据库交互
            Timestamp startTimestamp = Timestamp.valueOf(startTime);
            Timestamp endTimestamp = Timestamp.valueOf(endTime);

            accessEventService.addaccess(i, startTimestamp, "上班");
            accessEventService.addaccess(i, endTimestamp, "下班");
            accessEventService.addclock_in(i, startTimestamp, endTimestamp);
        }

        return Result.success(1);
    }
}
