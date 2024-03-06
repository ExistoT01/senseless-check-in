package org.ouc.management.Controller;

import lombok.extern.slf4j.Slf4j;
import org.ouc.common.result.Result;
import org.ouc.management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable String id) {
        log.debug("收到员工id: {}", id);
        return empService.getById(id);
    }
}
