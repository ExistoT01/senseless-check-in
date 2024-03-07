package org.ouc.schedule.Controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.ouc.common.result.Result;
import org.ouc.schedule.service.AccessEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accessEvent")
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
}
